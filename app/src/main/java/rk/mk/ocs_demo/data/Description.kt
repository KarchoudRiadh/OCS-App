package rk.mk.ocs_demo

import com.google.gson.annotations.SerializedName

   
data class Description (

   @SerializedName("type") var type : String,
   @SerializedName("value") var value : String,
   @SerializedName("color") var color : String

)