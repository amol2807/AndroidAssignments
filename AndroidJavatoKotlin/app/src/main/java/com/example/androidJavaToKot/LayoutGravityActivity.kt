package com.example.androidJavaToKot

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity


class LayoutGravityActivity : AppCompatActivity() {

    private var TAG = "LayoutGravityActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_gravity)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_layout_gravity,menu)
        Log.v(TAG,"onCreateOptionsMenu called")
        return true

    }

}