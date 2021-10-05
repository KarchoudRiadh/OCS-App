package rk.mk.ocs_demo.data

import com.google.gson.annotations.SerializedName
import rk.mk.ocs_demo.Availability
import rk.mk.ocs_demo.Bannerinfo
import rk.mk.ocs_demo.Seasons
import rk.mk.ocs_demo.Zonesinfo


data class DetailedContents(

    @SerializedName("parentalrating") var parentalrating: Int,
    @SerializedName("isbookmarkable") var isbookmarkable: Boolean,
    @SerializedName("isdownloadable") var isdownloadable: Boolean,
    @SerializedName("number") var number: String,
    @SerializedName("title") var title: List<Title>,
    @SerializedName("duration") var duration: String,
    @SerializedName("availability") var availability: List<Availability>,
    @SerializedName("summary") var summary: String,
    @SerializedName("highlefticon") var highlefticon: String,
    @SerializedName("highrighticon") var highrighticon: String,
    @SerializedName("subtitle") var subtitle: String,
    @SerializedName("subtitlefocus") var subtitlefocus: String,
    @SerializedName("pitch") var pitch: String,
    @SerializedName("bannerinfo") var bannerinfo: List<Bannerinfo>,
    @SerializedName("description") var description: List<List<String>>,
    @SerializedName("imageurl") var imageurl: String,
    @SerializedName("fullscreenimageurl") var fullscreenimageurl: String,
    @SerializedName("linearplanning") var linearplanning: List<String>,
    @SerializedName("acontents") var acontents: List<Acontents>,
    @SerializedName("playinfoid") var playinfoid: Playinfoid,
    @SerializedName("playinfo") var playinfo: Playinfo,
    @SerializedName("id") var id: String,
    @SerializedName("zonesinfo") var zonesinfo: Zonesinfo,
    @SerializedName("highlightid") var highlightid: String,
    @SerializedName("selectid") var selectid: String,
    @SerializedName("detaillink") var detaillink: String,
    @SerializedName("seasons") var seasons: List<Seasons>,

    ) {
    override fun toString(): String {
        return "DetailedContents(parentalrating=$parentalrating, isbookmarkable=$isbookmarkable, isdownloadable=$isdownloadable, number='$number', title=$title, duration='$duration', availability=$availability, summary='$summary', highlefticon='$highlefticon', highrighticon='$highrighticon', subtitle='$subtitle', subtitlefocus='$subtitlefocus', pitch='$pitch', bannerinfo=$bannerinfo, description=$description, imageurl='$imageurl', fullscreenimageurl='$fullscreenimageurl', linearplanning=$linearplanning, acontents=$acontents, playinfoid=$playinfoid, playinfo=$playinfo, id='$id', zonesinfo=$zonesinfo, highlightid='$highlightid', selectid='$selectid', detaillink='$detaillink', seasons=$seasons)"
    }
}