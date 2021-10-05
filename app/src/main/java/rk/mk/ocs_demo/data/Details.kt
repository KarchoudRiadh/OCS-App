package rk.mk.ocs_demo.data

import com.google.gson.annotations.SerializedName
import rk.mk.ocs_demo.data.DetailedContents


data class Details(

    @SerializedName("template") var template: String,
    @SerializedName("parentalrating") var parentalrating: Int,
    @SerializedName("categoryID") var categoryID: Int,
    @SerializedName("contents") var detailedContents: DetailedContents

) {
    override fun toString(): String {
        return "Details(template='$template', parentalrating=$parentalrating, categoryID=$categoryID, detailedContents=$detailedContents)"
    }
}