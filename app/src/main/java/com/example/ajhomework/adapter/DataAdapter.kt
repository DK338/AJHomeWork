package com.example.ajhomework.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings.Global.putString
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ajhomework.activitys.MainActivity
import com.example.ajhomework.activitys.SecendActivity
import com.example.ajhomework.databinding.DataTimeItemBinding
import com.example.ajhomework.models.DataTime

class DataAdapter(var dataTimes: MutableList<DataTime>): RecyclerView.Adapter<DataAdapter.DataTimeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.DataTimeViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataTimeItemBinding.inflate(layoutInflater,parent,false)

        return DataTimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataAdapter.DataTimeViewHolder, position: Int) {

        holder.bingDataTime(dataTimes.get(position))
        val context = holder.binding.root.context
        holder.itemView.setOnClickListener {
            val intent = Intent(context,SecendActivity::class.java)

            val bundle= Bundle().apply {
                val startTime = holder.binding.dataTime?.startTime!!
                val endTime = holder.binding.dataTime?.endTime!!
                val parameterName =  holder.binding.dataTime?.parameterName?.parameterName!!
                val parameterUnit =  holder.binding.dataTime?.parameterName?.parameterUnit!!
                putString("StartTime", startTime)
                putString("EndTime", endTime)
                putString("ParameterName", parameterName)
                putString("ParameterUnit", parameterUnit)
            }
            intent.putExtra("bundle",bundle)
//            Log.d("傳送資料(StartTime)",holder.binding.dataTime?.startTime!!)
//            Log.d("傳送資料(endTime)",holder.binding.dataTime?.endTime!!)
//            Log.d("傳送資料(parameter)",
//                holder.binding.dataTime?.parameterName?.parameterName!!+
//                     holder.binding.dataTime?.parameterName?.parameterUnit!!)

//            Toast.makeText(holder.binding.root.context,"點擊:${position}",Toast.LENGTH_SHORT).show()
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        Log.d("getItemCount",dataTimes.size.toString())
        return dataTimes.size;
    }

    class DataTimeViewHolder(val binding: DataTimeItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bingDataTime(dataTime: DataTime) {
            binding.dataTime = dataTime
            binding.executePendingBindings()
        }
    }

}