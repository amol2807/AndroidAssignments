package com.example.androidJavaToKot

import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PersistSettingsActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var edits: SharedPreferences.Editor
    private lateinit var textView: TextView
    private lateinit var checkBox: CheckBox
    private lateinit var button : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persist_settings)
        textView  = findViewById(R.id.PSA_editText)
        checkBox = findViewById(R.id.PSA_checkBox)
        button  = findViewById(R.id.PSA_button)
        sharedPreferences =getSharedPreferences("view",0)
        edits = sharedPreferences.edit()
        populateValues()
        button.setOnClickListener {
            persistValues()
        }
    }

    private fun persistValues() {
        edits.putString("textVal",textView.text.toString())
        edits.putBoolean("checkState",checkBox.isChecked)
        edits.commit()
        Toast.makeText(this, "Persisted!", Toast.LENGTH_SHORT).show()
    }

    private fun populateValues() {
        val persistedText  =sharedPreferences.getString("textVal","None Stored Yet")
        val isChecked = sharedPreferences.getBoolean("checkState",false)
        textView.text = persistedText
        checkBox.isChecked = isChecked
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_persist_settings, menu)
        return true
    }
}