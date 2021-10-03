package com.example.androidJavaToKot

import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SpinnerToastActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner_toast)

        spinner  =findViewById(R.id.STA_spinner)
        button = findViewById(R.id.STA_button)
        loadSpinner()

        button.setOnClickListener {
            displayVal()
        }
    }

    private fun loadSpinner() {

        val adapter =ArrayAdapter.createFromResource(this,R.array.spinner_options,R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_spinner_with_toast, menu)
        return true
    }

    private fun displayVal() {
        Toast.makeText(this, spinner.selectedItem.toString(), Toast.LENGTH_SHORT).show()
    }

}