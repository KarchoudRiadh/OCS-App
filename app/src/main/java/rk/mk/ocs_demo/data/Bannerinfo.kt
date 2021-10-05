package rk.mk.ocs_demo

import com.google.gson.annotations.SerializedName

   
data class Bannerinfo (

   @SerializedName("type") var type : String,
   @SerializedName("value") var value : String,
   @SerializedName("color") var color : String

) {
   override fun toString(): String {
      return "Bannerinfo(type='$type', value='$value', color='$color')"
   }
}