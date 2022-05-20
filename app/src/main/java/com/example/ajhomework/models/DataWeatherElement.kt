package com.example.ajhomework.models

import com.google.gson.annotations.SerializedName

data class DataWeatherElement (

    @SerializedName("elementName")
    var elementName: String,

    @SerializedName("time")
    var dataTimes: List<DataTime>

)


