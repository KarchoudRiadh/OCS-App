package rk.mk.ocs_demo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import rk.mk.ocs_demo.data.Contents
import rk.mk.ocs_demo.data.Details
import rk.mk.ocs_demo.data.Search
import rk.mk.ocs_demo.data.SelectedShow
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.ProtocolException
import java.net.URL
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener,
    OnItemClickListener, View.OnClickListener {
    private val baseUrl = "https://api.ocs.fr"
    private val baseSearchUrl = "$baseUrl/apps/v2/contents?search=title%3D"

    private val executor: ExecutorService = Executors.newSingleThreadExecutor()
    private val handler = Handler(Looper.getMainLooper())
    private var ready = false

    private lateinit var searchResult: Search
    private lateinit var selectedShowDetails: Details
    private lateinit var title: TextView
    private lateinit var message: TextView
    private lateinit var playButton: Button
    private lateinit var searchBar: SearchView
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchResultsAdapter: SearchResultsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        title = findViewById<View>(R.id.title_app) as TextView
        message = findViewById(R.id.message)
        searchBar = findViewById(R.id.search_view)
        searchBar.setOnQueryTextListener(this)
        recyclerView = findViewById<View>(R.id.show_view) as RecyclerView
        playButton = findViewById(R.id.next_button)
        playButton.setOnClickListener(this)
    }

    override fun onQueryTextSubmit(keyword: String?): Boolean {
        if (keyword != null) {
            if (keyword.length > 1) searchShows(keyword)
            return true
        }
        return false
    }

    override fun onQueryTextChange(keyword: String?): Boolean {
        return false
    }

    private fun searchShowDetails() {
        executor.execute {
            selectedShowDetails =
                fetchDetails(searchResult.contents?.get(0)!!.detaillink)
            handler.post {
                val show = searchResult.contents?.get(0)
                Log.e("TAG", selectedShowDetails.toString())
                var description = ""
                if (selectedShowDetails.detailedContents.pitch != null) {
                    description = selectedShowDetails.detailedContents.pitch
                } else if (selectedShowDetails.detailedContents.seasons[0] != null) {
                    description = selectedShowDetails.detailedContents.seasons[0].pitch
                }

                show.let {
                    var selectedShow = SelectedShow(
                        show?.fullscreenimageurl!!,
                        show.title[0].value,
                        show.subtitle,
                        description
                    )
                    var intent = Intent(this, PlayerActivity::class.java)
                    intent.putExtra("SHOW", selectedShow)
                    startActivity(intent)
                }
            }
        }
    }

    private fun searchShows(keyword: String?) {
        executor.execute {
            searchResult = fetchShows(keyword)
            handler.post {
                if (searchResult.count > 0) {
                    ready = true
                    recyclerView.visibility = View.VISIBLE
                    message.visibility = View.INVISIBLE
                    playButton.visibility = View.VISIBLE
                    searchResultsAdapter =
                        searchResult.contents?.let { SearchResultsAdapter(it, this) }!!
                    recyclerView.adapter = searchResultsAdapter
                    recyclerView.layoutManager = LinearLayoutManager(this)
                    recyclerView.setOnClickListener(this)
                } else {
                    recyclerView.visibility = View.INVISIBLE
                    message.visibility = View.VISIBLE
                    message.text = "No results found for " + keyword
                }
            }
        }
    }

    override fun onItemClicked(content: Contents) {
        Toast.makeText(this, content.title[0].value + " is clicked", Toast.LENGTH_LONG)
    }

    override fun onClick(p0: View?) {
        if (ready) {
            searchShowDetails()
        }
    }

    private fun fetchShows(keyword: String?): Search {
        var response = ""
        try {
            var url = URL(baseSearchUrl + keyword);
            var conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            var input = BufferedInputStream(conn.inputStream)
            response = convertStreamToString(input)
        } catch (e: MalformedURLException) {
            Log.e("TAG", "MalformedURLException: " + e.message)
        } catch (e: ProtocolException) {
            Log.e("TAG", "ProtocolException: " + e.message)
        } catch (e: IOException) {
            Log.e("TAG", "IOException: " + e.message)
        } catch (e: Exception) {
            Log.e("TAG", "Exception: " + e.message)
        }
        return Gson().fromJson(
            response,
            Search::class.java
        )
    }

    private fun fetchDetails(detailLink: String?): Details {
        var response = ""
        var url = URL(baseUrl + detailLink)
        Log.e("TAG", baseUrl + detailLink)
        var conn = url.openConnection() as HttpURLConnection
        try {
            conn.requestMethod = "GET"
            var stream = conn.inputStream
            var input = BufferedInputStream(stream)
            Log.e("TAG", input.toString())
            response = convertStreamToString(input)
        } catch (e: MalformedURLException) {
            Log.e("TAG", "MalformedURLException: " + e.message)
        } catch (e: ProtocolException) {
            Log.e("TAG", "ProtocolException: " + e.message)
        } catch (e: IOException) {
            Log.e("TAG", "IOException: " + e.message)
        } catch (e: Exception) {
            Log.e("TAG", "Exception: " + e.stackTrace)
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return Gson().fromJson(
            response,
            Details::class.java
        )
    }

    private fun convertStreamToString(input: InputStream): String {
        val reader = BufferedReader(input.reader())
        val content = StringBuilder()
        reader.use { reader ->
            var line = reader.readLine()
            while (line != null) {
                content.append(line)
                line = reader.readLine()
            }
        }
        return content.toString()
    }
}
