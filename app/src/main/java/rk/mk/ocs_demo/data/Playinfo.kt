package rk.mk.ocs_demo.data

import com.google.gson.annotations.SerializedName

   
data class Playinfo (

   @SerializedName("tokenurl") var tokenurl : String,
   @SerializedName("url") var url : String

) {
   override fun toString(): String {
      return "Playinfo(tokenurl='$tokenurl', url='$url')"
   }
}