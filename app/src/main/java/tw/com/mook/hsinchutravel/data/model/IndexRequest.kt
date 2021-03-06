package tw.com.mook.hsinchutravel.data.model

import com.google.gson.annotations.SerializedName

data class IndexRequest constructor(

    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("cmd")
    val cmd: String = "appHome"
)