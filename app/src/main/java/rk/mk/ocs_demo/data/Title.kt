package rk.mk.ocs_demo.data

import com.google.gson.annotations.SerializedName

   
data class Title (

   @SerializedName("color") var color : String,
   @SerializedName("type") var type : String,
   @SerializedName("value") var value : String

) {
   override fun toString(): String {
      return "Title(color='$color', type='$type', value='$value')"
   }
}