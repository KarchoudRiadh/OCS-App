package rk.mk.ocs_demo.data

import com.google.gson.annotations.SerializedName


data class Lowrightinfo(

    @SerializedName("type") var text: String,
    @SerializedName("value") var value: String,
    @SerializedName("color") var color: String

) {
    override fun toString(): String {
        return "Lowrightinfo(text='$text', value='$value', color='$color')"
    }
}