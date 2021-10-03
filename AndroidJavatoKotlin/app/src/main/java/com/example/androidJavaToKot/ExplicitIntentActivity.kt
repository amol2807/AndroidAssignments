package com.example.androidJavaToKot

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ExplicitIntentActivity : AppCompatActivity() {

    private lateinit var button1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit_intent)

        button1 = findViewById(R.id.EI_button1)
        button1.setOnClickListener {
            val intent = Intent(this, SimpleBundleDemoActivity::class.java)
            intent.putExtra("text", "Passed from explicit Intent Activity")
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_explicit_intent, menu)
        return true

    }
}