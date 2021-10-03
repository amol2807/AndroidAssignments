package com.example.androidJavaToKot

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity

class BasicTextViewActivity : AppCompatActivity() {

    private var TAG = "BasicTextViewActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_text_view)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_basic_text_view,menu)
        Log.v(TAG,"onCreateOptionsMenu called")
        return true

    }

    override fun onResume(){
        super.onResume()
        Log.v(TAG,"OnResume called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(TAG,"onRestart called")
    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG,"onStart called")
    }

    override fun onStop() {
        super.onStop()
        Log.v(TAG,"onStart called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG,"onDestroy called")

    }
}