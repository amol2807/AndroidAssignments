package com.example.androidJavaToKot

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SimpleResultReturnActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var resultText:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_result_return)
        button =  findViewById(R.id.SRR_button)
        button.setOnClickListener {
            sendResult()
        }
    }

    private fun sendResult() {

        resultText= findViewById(R.id.SRR_textView)
        val result = resultText.text.toString()
        val intent = Intent()
        intent.putExtra("result",result)
        setResult(RESULT_OK,intent)
        finish()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.activity_simple_result_return,menu)
        return true

    }
}