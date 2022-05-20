package com.example.ajhomework.responses

import com.example.ajhomework.models.DataRecords
import com.google.gson.annotations.SerializedName

data class DataResponse (
    @SerializedName("success")
    var success: String,

//    var result: String = "Yes",

    @SerializedName("records")
    var records: DataRecords
)



