package com.example.ajhomework.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.ajhomework.R
import com.example.ajhomework.activitys.SecendActivity

import com.example.ajhomework.models.DataTime

class NewDataAdapter( private val dataTimes: MutableList<DataTime>): Adapter<RecyclerView.ViewHolder>(){

    val DATATYPE=0
    val IMAGETYPE=1


    override fun getItemViewType(position: Int): Int {
        if (position%3!=2) return DATATYPE else return IMAGETYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        if (viewType==DATATYPE)
            return DataTimeViewHolder(layoutInflater.inflate(R.layout.data_time_item,null))
        else
            return ImageitemViewHolder(layoutInflater.inflate(R.layout.image_item,null))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if(position%3!=2)
        {
            val dataTime = dataTimes.get(position)
            var startTime: TextView = holder.itemView.findViewById<TextView>(R.id.startTime)
            var endTime: TextView = holder.itemView.findViewById<TextView>(R.id.endTime)
            var parameter: TextView = holder.itemView.findViewById<TextView>(R.id.parameter)
            startTime.text = dataTime.startTime
            endTime.text = dataTime.endTime

            val parameterName = dataTime.parameterName.parameterName
            val parameterUnit = dataTime.parameterName.parameterUnit

            parameter.text = parameterName+parameterUnit

            holder.itemView.setOnClickListener {
                val context = holder.itemView.context
                val intent = Intent(context, SecendActivity::class.java)

                val bundle= Bundle().apply {

                    putString("StartTime", startTime.text.toString())
                    putString("EndTime", endTime.text.toString())
                    putString("ParameterName", parameterName.toString())
                    putString("ParameterUnit", parameterUnit.toString())

                }
                intent.putExtra("bundle",bundle)
                context.startActivity(intent)

            }

        }
        else{
            var imageView: ImageView = holder.itemView.findViewById<ImageView>(R.id.imageView)
            imageView.setImageResource(R.drawable.ic_launcher_background)
        }



    }

    override fun getItemCount(): Int {
        return dataTimes.size
    }

    class DataTimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    class ImageitemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}




