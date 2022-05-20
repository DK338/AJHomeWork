package com.example.ajhomework.network

import com.example.ajhomework.responses.DataResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("v1/rest/datastore/F-C0032-001?Authorization=CWB-7385ACF5-9FCF-42FA-AB62-AE81508E39F9&format=JSON&locationName=%E8%87%BA%E5%8C%97%E5%B8%82&elementName=MinT")
    fun getDataResponse(): Call<DataResponse>

}