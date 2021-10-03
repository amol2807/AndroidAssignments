package com.example.androidJavaToKot

import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SimpleBundleDemoActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_bundle_demo)

        val text = intent.getStringExtra("text")

        textView = findViewById(R.id.SBD_textView)
        if (text != null) {
            textView.text = text
        }
        actionBar?.setHomeButtonEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_simple_bundle_demo, menu)
        return true
    }
}