package com.example.androidJavaToKot

import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TimePickerActivity : AppCompatActivity() {

    private lateinit var timePicker: TimePicker
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker)
        timePicker = findViewById(R.id.TPA_timePicker)
        button = findViewById(R.id.TPA_button)
        button.setOnClickListener { displayTime() }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_time_picker_demo, menu)
        return true
    }

    private fun displayTime() {
        val time: String = timePicker.hour.toString() + ":" + timePicker.minute
        Toast.makeText(this, time, Toast.LENGTH_SHORT).show()
    }
}