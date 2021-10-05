package rk.mk.ocs_demo.data

import com.google.gson.annotations.SerializedName


data class Search(
    @SerializedName("template") var template: String,
    @SerializedName("parentalrating") var parentalrating: Int,
    @SerializedName("title") var title: String,
    @SerializedName("offset") var offset: Int,
    @SerializedName("limit") var limit: String,
    @SerializedName("next") var next: String,
    @SerializedName("previous") var previous: String,
    @SerializedName("total") var total: Int,
    @SerializedName("count") var count: Int,
    @SerializedName("filter") var filter: String,
    @SerializedName("sort") var sort: String,
    @SerializedName("contents") var contents: List<Contents>?
) {
    override fun toString(): String {
        return "Search(template='$template', parentalrating=$parentalrating, title='$title', offset=$offset, limit='$limit', next='$next', previous='$previous', total=$total, count=$count, filter='$filter', sort='$sort', contents=$contents)"
    }
}