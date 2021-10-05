package rk.mk.ocs_demo

import com.google.gson.annotations.SerializedName

   
data class Zonesinfo (

   @SerializedName("duration") var duration : Int,
   @SerializedName("endcreditsautocompleted") var endcreditsautocompleted : Boolean,
   @SerializedName("previouslytcin") var previouslytcin : String,
   @SerializedName("previouslytcout") var previouslytcout : String,
   @SerializedName("startcreditstcin") var startcreditstcin : Int,
   @SerializedName("startcreditstcout") var startcreditstcout : Int,
   @SerializedName("endcreditstcin") var endcreditstcin : Int,
   @SerializedName("endcreditstcout") var endcreditstcout : Int

) {
   override fun toString(): String {
      return "Zonesinfo(duration=$duration, endcreditsautocompleted=$endcreditsautocompleted, previouslytcin='$previouslytcin', previouslytcout='$previouslytcout', startcreditstcin=$startcreditstcin, startcreditstcout=$startcreditstcout, endcreditstcin=$endcreditstcin, endcreditstcout=$endcreditstcout)"
   }
}