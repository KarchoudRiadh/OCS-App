package rk.mk.ocs_demo.data

import com.google.gson.annotations.SerializedName


data class Contents (

    @SerializedName("title") var title : List<Title>,
    @SerializedName("subtitle") var subtitle : String,
    @SerializedName("subtitlefocus") var subtitlefocus : List<String>,
    @SerializedName("highlefticon") var highlefticon : List<String>,
    @SerializedName("highrighticon") var highrighticon : List<String>,
    @SerializedName("lowrightinfo") var lowrightinfo : List<Lowrightinfo>,
    @SerializedName("imageurl") var imageurl : String?,
    @SerializedName("fullscreenimageurl") var fullscreenimageurl : String?,
    @SerializedName("id") var id : String,
    @SerializedName("detaillink") var detaillink : String,
    @SerializedName("duration") var duration : String,
    @SerializedName("playinfoid") var playinfoid : Playinfoid

) {
    override fun toString(): String {
        return "Contents(title=$title, subtitle='$subtitle', subtitlefocus='$subtitlefocus', highlefticon='$highlefticon', highrighticon='$highrighticon', lowrightinfo='$lowrightinfo', imageurl='$imageurl', fullscreenimageurl='$fullscreenimageurl', id='$id', detaillink='$detaillink', duration='$duration', playinfoid=$playinfoid)"
    }
}