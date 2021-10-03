package com.example.androidJavaToKot

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class BasicClickHandlersActivity : AppCompatActivity() {

    private lateinit var button1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_click_handlers)

        button1 = findViewById(R.id.CH_button1)

        button1.setOnClickListener { firstButtonClicked() }

    }

    private fun firstButtonClicked() {
        AlertDialog.Builder(this).setTitle("BasicClickHandlersActivity")
            .setMessage("firstButton clicked via code")
            .setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.cancel()})
            .show()
        Toast.makeText(this, "First Button Clicked from code", Toast.LENGTH_SHORT).show()
    }

    public fun secondButtonClicked(view: View?) {
        AlertDialog.Builder(this).setTitle("BasicClickHandlersActivity")
            .setMessage("Second Button Clicked from XML")
            .setPositiveButton("Ok", DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.cancel()})
            .show()
        Toast.makeText(this, "Second Button Clicked from XML", Toast.LENGTH_SHORT).show()
    }

}