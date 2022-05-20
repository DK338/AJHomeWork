package com.example.ajhomework.models

import com.google.gson.annotations.SerializedName

data class DataTime (

    @SerializedName("startTime")
    var startTime: String,

    @SerializedName("endTime")
    var endTime: String,

    @SerializedName("parameter")
    var parameterName: DataParameter

)
