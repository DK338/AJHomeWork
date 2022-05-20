package com.example.ajhomework.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ajhomework.models.DataParameter
import com.example.ajhomework.models.DataTime
import com.example.ajhomework.network.ApiClient
import com.example.ajhomework.network.ApiService
import com.example.ajhomework.responses.DataResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.create

class DatasRepository {
    val apiService: ApiService = ApiClient().getRetrofit().create(ApiService::class.java)

    fun getDataResponses(): LiveData<DataResponse>? {

        var data: MutableLiveData<DataResponse> = MutableLiveData()
        apiService.getDataResponse().enqueue(object: retrofit2.Callback<DataResponse>{
            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                data.value = response.body()
//                Log.d("success", response.body().toString())
//                Log.d("success", response.body()?.records?.dataLocations?.get(0)?.dataWeatherElements?.get(0)?.dataTimes?.size.toString())
                data = changeTimeData(data)

            }

            override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                data.value = null
            }

        })

        return data
    }

    fun changeTimeData( data: MutableLiveData<DataResponse>): MutableLiveData<DataResponse>{

        var dataTimes: MutableList<DataTime> = mutableListOf<DataTime>()

        dataTimes.addAll(data.value?.records?.dataLocations?.get(0)?.dataWeatherElements?.get(0)?.dataTimes!!)

        for (i in 0 until dataTimes.size){
//            Log.d("處理(1):",dataTimes.get(i).startTime)
//            Log.d("處理(2):",dataTimes.get(i).endTime)
            dataTimes.get(i).startTime = dataTimes.get(i).startTime.replace("-","/")
            dataTimes.get(i).endTime = dataTimes.get(i).endTime.replace("-","/")
//            Log.d("處理(3):",dataTimes.get(i).startTime)
//            Log.d("處理(4):",dataTimes.get(i).endTime)
        }

        return data
    }
}