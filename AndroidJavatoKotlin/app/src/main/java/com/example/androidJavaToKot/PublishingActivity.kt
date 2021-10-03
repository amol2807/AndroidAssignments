package com.example.androidJavaToKot

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity

class PublishingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publishing)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_publishing_instructions, menu)
        return true
    }
}