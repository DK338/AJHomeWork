package com.example.ajhomework.models

import com.google.gson.annotations.SerializedName

data class DataRecords (

    @SerializedName("datasetDescription")
    var datasetDescription: String,

    @SerializedName("location")
    var dataLocations: List<DataLocation>

)


