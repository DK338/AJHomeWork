package com.example.ajhomework.models

import com.google.gson.annotations.SerializedName

data class DataParameter (

    @SerializedName("parameterName")
    var parameterName: String,

    @SerializedName("parameterUnit")
    var parameterUnit: String

)


