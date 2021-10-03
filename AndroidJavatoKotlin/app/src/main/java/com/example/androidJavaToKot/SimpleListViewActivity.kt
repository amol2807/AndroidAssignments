package com.example.androidJavaToKot

import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class SimpleListViewActivity : AppCompatActivity() {

    private lateinit var listView:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_list_view)
        val myStringArray = arrayOf("Apples", "Bananas", "Oranges")
        val adapter = ArrayAdapter(
            this,
            R.layout.simple_list_item, myStringArray
        )
        listView = findViewById(R.id.SL_listView)
        listView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_simple_list_view, menu)
        return true
    }
}