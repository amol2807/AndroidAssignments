package com.example.androidJavaToKot

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ListViewClickActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var listViewAdapter: ArrayAdapter<String>
    private var myProjects = listOf("Proj1.", "Proj2", "Proj3")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_click)
        Log.v("ListViewClickActivity","ListviewAdpater Being Set")
        listViewAdapter = ArrayAdapter(this, R.layout.simple_list_item, myProjects)
        Log.v("ListViewClickActivity","ListviewAdpater is Set")

        listView = findViewById(R.id.LVC_listView)
        listView.adapter = listViewAdapter

        listView.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                val proj: String? = listViewAdapter.getItem(position)
                AlertDialog.Builder(this).setTitle("BasicClickHandlersActivity")
                    .setMessage("Project $proj")
                    .setPositiveButton("Ok", DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.cancel()})
                    .show()
                Toast.makeText(this, proj, Toast.LENGTH_SHORT).show()
            }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_list_view_clicks, menu)
        return true
    }

}