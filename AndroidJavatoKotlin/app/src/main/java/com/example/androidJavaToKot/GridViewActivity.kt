package com.example.androidJavaToKot

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat

class GridViewActivity : AppCompatActivity() {

    private lateinit var gridView:GridView
    private lateinit var adapter: GridImageAdapter

    internal class GridImageAdapter(
        context: Context?,
        textViewResourceId: Int,
        numbers: Array<String>
    ) :
        ArrayAdapter<String?>(context!!, textViewResourceId, numbers) {
//        @SuppressLint("UseCompatLoadingForDrawables")
        @SuppressLint("UseCompatLoadingForDrawables")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val v = ImageView(context)
            val resId: Int =
                context.resources.getIdentifier(getItem(position), "drawable", context.packageName)
            v.setImageDrawable(ResourcesCompat.getDrawable(context.resources,R.drawable.ic_launcher_background,null))
            return v
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("GridViewActivity","OnCreate called")
        setContentView(R.layout.activity_grid_view)

        populateGridView()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_grid_view_demo, menu)
        return true
    }
    private fun populateGridView() {

        gridView = findViewById(R.id.GA_gridView)
        val numbers = arrayOf("ad", "ae", "af", "ag", "ai", "al")
        adapter = GridImageAdapter(this,R.layout.simple_list_item_1,numbers)
        gridView.adapter =adapter

    }
}