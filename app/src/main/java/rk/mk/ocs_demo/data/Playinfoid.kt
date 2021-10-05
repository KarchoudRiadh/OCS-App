package rk.mk.ocs_demo.data

import com.google.gson.annotations.SerializedName


data class Playinfoid (

   @SerializedName("hd") var hd : String,
   @SerializedName("sd") var sd : String,
   @SerializedName("uhd") var uhd : String

) {
   override fun toString(): String {
      return "Playinfoid(hd='$hd', sd='$sd', uhd='$uhd')"
   }
}