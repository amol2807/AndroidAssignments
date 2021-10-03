package com.example.androidJavaToKot

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ViewAttributesActivity : AppCompatActivity() {

    private lateinit var textView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_attributes)
        textView = findViewById(R.id.VA_textView)
        Log.d("DEBUG", textView.text.toString())
        Toast.makeText(this, textView.text.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_view_attributes, menu)
        return true
    }
}