package com.example.ajhomework.models

import com.google.gson.annotations.SerializedName

data class DataLocation (

    @SerializedName("locationName")
    var locationName: String,

    @SerializedName("weatherElement")
    var dataWeatherElements: List<DataWeatherElement>

)

