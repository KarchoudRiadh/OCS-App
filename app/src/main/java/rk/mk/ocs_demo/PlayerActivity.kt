package rk.mk.ocs_demo

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.dash.DashMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import com.google.android.exoplayer2.upstream.*
import rk.mk.ocs_demo.data.SelectedShow


class PlayerActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var selectedShow: SelectedShow
    private lateinit var title: TextView
    private lateinit var subtitle: TextView
    private lateinit var description: TextView
    private lateinit var imageBg: ImageView
    private lateinit var playButton: ImageView
    var exoPlayerView: SimpleExoPlayerView? = null
    var exoPlayer: SimpleExoPlayer? = null
    private var videoURL =
        "https://bitmovin-a.akamaihd.net/content/MI201109210084_1/mpds/f08e80da-bf1d-4e3d-8899-f0f6155f6efa.mpd"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        selectedShow = (intent.getSerializableExtra("SHOW") as? SelectedShow)!!
        title = findViewById<View>(R.id.player_show_title) as TextView
        title.text = selectedShow.title
        subtitle = findViewById<View>(R.id.player_show_subtitle) as TextView
        subtitle.text = selectedShow.subtitle
        description = findViewById<View>(R.id.player_show_details) as TextView
        description.text = selectedShow.description
        imageBg = findViewById<View>(R.id.player_img) as ImageView
        playButton = findViewById<View>(R.id.play_button) as ImageView
        playButton.setOnClickListener(this)
        supportActionBar?.hide()
        Glide.with(imageBg)
            .load("https://statics.ocs.fr" + (selectedShow.imageUrl))
            .into(imageBg)
        exoPlayerView = findViewById(R.id.idExoPlayerView);
    }


    override fun onClick(v: View?) {
        when (v) {
            playButton -> {
                exoPlayerView!!.visibility = View.VISIBLE
                title.visibility = View.INVISIBLE
                subtitle.visibility = View.INVISIBLE
                playButton.visibility = View.INVISIBLE
                imageBg.visibility = View.INVISIBLE
                description.visibility = View.INVISIBLE
                try {
                    var bandwidthMeter = DefaultBandwidthMeter()
                    var trackSelector =
                        DefaultTrackSelector(AdaptiveTrackSelection.Factory(bandwidthMeter))
                    val loadControl =
                        DefaultLoadControl.Builder()
                            .setBufferDurationsMs(64 * 1024, 128 * 1024, 1024, 1024)
                            .createDefaultLoadControl()
                    exoPlayer = ExoPlayerFactory.newSimpleInstance(
                        this,
                        DefaultRenderersFactory(this),
                        trackSelector,
                        loadControl
                    )
                    var videoUri = Uri.parse(videoURL)
                    val dataSourceFactory: DataSource.Factory =
                        DefaultDataSourceFactory(this@PlayerActivity, "ua")
                    var mediaSource =
                        DashMediaSource.Factory(dataSourceFactory).createMediaSource(videoUri)

                    exoPlayerView!!.player = exoPlayer
                    exoPlayer!!.prepare(mediaSource)
                    exoPlayer!!.playWhenReady = true
                } catch (e: Exception) {
                    Log.e("TAG", "Error : $e");
                }
            }
        }
    }

}