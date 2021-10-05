package rk.mk.ocs_demo.data

import com.google.gson.annotations.SerializedName
import rk.mk.ocs_demo.Description


data class Acontents(

    @SerializedName("type") var type: String,
    @SerializedName("description") var description: List<Description>,
    @SerializedName("link") var link: String,
    @SerializedName("imageurl") var imageurl: String,
    @SerializedName("contents") var contents: List<Contents>

) {
    override fun toString(): String {
        return "Acontents(type='$type', description=$description, link='$link', imageurl='$imageurl', contents=$contents)"
    }
}