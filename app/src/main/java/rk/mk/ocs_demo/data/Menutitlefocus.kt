package rk.mk.ocs_demo

import com.google.gson.annotations.SerializedName

   
data class Menutitlefocus (

   @SerializedName("type") var type : String,
   @SerializedName("value") var value : String,
   @SerializedName("color") var color : String

) {
   override fun toString(): String {
      return "Menutitlefocus(type='$type', value='$value', color='$color')"
   }
}