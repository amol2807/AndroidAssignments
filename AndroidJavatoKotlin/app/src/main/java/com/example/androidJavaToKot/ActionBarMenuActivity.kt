package com.example.androidJavaToKot

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActionBarMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action_bar_menu)
        actionBar?.title = "Click an Icon"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_action_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_toast -> Toast.makeText(this, "Toasted", Toast.LENGTH_SHORT).show()
            R.id.menu_settings -> {
                val intent = Intent(this, SimpleBundleDemoActivity::class.java)
                startActivity(intent)
            }
            else -> Toast.makeText(this, "Something Wrong!!", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}