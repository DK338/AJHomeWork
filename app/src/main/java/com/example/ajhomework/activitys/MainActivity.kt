package com.example.ajhomework.activitys

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ajhomework.R
import com.example.ajhomework.adapter.DataAdapter
import com.example.ajhomework.adapter.NewDataAdapter
import com.example.ajhomework.databinding.ActivityMainBinding
import com.example.ajhomework.models.DataParameter
import com.example.ajhomework.models.DataTime
import com.example.ajhomework.responses.DataResponse
import com.example.ajhomework.viewModels.DataResponseViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: DataResponseViewModel
    private var dataTimes: MutableList<DataTime> = mutableListOf<DataTime>()
    private lateinit var dataAdapter: NewDataAdapter

    private lateinit var sharePreferences: SharedPreferences
    private lateinit var editor:SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(DataResponseViewModel::class.java)

        dataAdapter = NewDataAdapter(dataTimes)
        val linearLayoutManager:LinearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerView.layoutManager = linearLayoutManager
        binding.recyclerView.adapter = dataAdapter
        binding.recyclerView.setHasFixedSize(true)

        getDataResponses()

        sharePreferences = getSharedPreferences("OpenCount", MODE_PRIVATE)
        editor = sharePreferences.edit()
        if (sharePreferences!=null)
            if(sharePreferences.getInt("Count",0)!=0)
                Toast.makeText(this, "歡迎回來",Toast.LENGTH_LONG).show()

    }


    override fun onStop() {
        super.onStop()
        if(sharePreferences.getInt("Count",0)==0)
            editor.putInt("Count",1).apply()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    fun getDataResponses() {

        var dataResponse:Observer<DataResponse> = Observer<DataResponse> {
//            Toast.makeText(this,"測試:"+it.success,Toast.LENGTH_LONG).show()
            Log.d("資料",it.records.dataLocations.get(0).locationName.toString())
            Log.d("資料",it.records.dataLocations.get(0).dataWeatherElements.get(0).dataTimes.toString())
            if (it.records.dataLocations.get(0).dataWeatherElements.get(0).dataTimes!=null){

                for (i in 0 until  it.records.dataLocations.get(0).dataWeatherElements.get(0).dataTimes.size){
                    var num = i+1

                    if(num%3==0)
                        dataTimes.add(DataTime("0","0", DataParameter("0","0")))
                        dataTimes.add(it.records.dataLocations.get(0).dataWeatherElements.get(0).dataTimes.get(i))

                }
//                dataTimes.addAll(it.records.dataLocations.get(0).dataWeatherElements.get(0).dataTimes)
                dataAdapter.notifyDataSetChanged()
            }

            Log.d("資料",dataTimes.toString())
        }
        viewModel.getDataResponses()?.observe(this, dataResponse)

    }


}