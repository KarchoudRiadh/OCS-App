package rk.mk.ocs_demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import rk.mk.ocs_demo.data.Contents

class SearchResultsAdapter(
    private val results: List<Contents>,
    private val itemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(results[position], itemClickListener)
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.search_element_layout, viewGroup, false)
        return ViewHolder(view)
    }
}

interface OnItemClickListener {
    fun onItemClicked(content: Contents)
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var title: TextView = view.findViewById(R.id.show_title)
    var subtitle: TextView = view.findViewById(R.id.subtitle)
    var showImage: ImageView = view.findViewById(R.id.show_image)
    var frame: FrameLayout = view.findViewById(R.id.show_frame)

    fun bind(content: Contents, clickListener: OnItemClickListener) {
        title.text = content.title[0].value
        subtitle.text = content.subtitle
        if (content.imageurl != null) {
            Glide.with(showImage)
                .load("https://statics.ocs.fr" + (content.imageurl))
                .into(showImage)
        }
        frame.setOnClickListener {
            clickListener.onItemClicked(content)
        }
    }
}
