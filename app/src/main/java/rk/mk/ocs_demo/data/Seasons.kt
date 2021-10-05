package rk.mk.ocs_demo

import com.google.gson.annotations.SerializedName
import rk.mk.ocs_demo.data.Acontents
import rk.mk.ocs_demo.data.Episodes


data class Seasons (

   @SerializedName("menutitle") var menutitle : List<Menutitle>,
   @SerializedName("subtitle") var subtitle : String,
   @SerializedName("number") var number : Int,
   @SerializedName("id") var id : String,
   @SerializedName("pitch") var pitch : String,
   @SerializedName("imageurl") var imageurl : String,
   @SerializedName("isbookmarkable") var isbookmarkable : Boolean,
   @SerializedName("episodes") var episodes : List<Episodes>,
   @SerializedName("highlefticon") var highlefticon : List<String>,
   @SerializedName("acontents") var acontents : List<Acontents>

) {
   override fun toString(): String {
      return "Seasons(menutitle=$menutitle, subtitle='$subtitle', number=$number, id='$id', pitch='$pitch', imageurl='$imageurl', isbookmarkable=$isbookmarkable, episodes=$episodes, highlefticon=$highlefticon, acontents=$acontents)"
   }
}