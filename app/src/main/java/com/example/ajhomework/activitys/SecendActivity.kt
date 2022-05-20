package com.example.ajhomework.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.ajhomework.R

class SecendActivity : AppCompatActivity() {
    lateinit var startTime: TextView
    lateinit var endTime: TextView
    lateinit var parameter: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secend)
        val intent = intent
        val bundle = intent.getBundleExtra("bundle")
//        val dataString =
//            bundle?.getString("StartTime") +"/n"+
//            bundle?.getString("EndTime")+"/n"+
//            bundle?.getString("ParameterName")+
//            bundle?.getString("ParameterUnit")

        startTime = findViewById(R.id.startTimeTextView)
        endTime = findViewById(R.id.endTimeTextView)
        parameter = findViewById(R.id.parameterTextView)

        startTime.text = bundle?.getString("StartTime").toString()
        endTime.text = bundle?.getString("EndTime").toString()
        parameter.text = bundle?.getString("ParameterName").toString()+ bundle?.getString("ParameterUnit").toString()
    }
}