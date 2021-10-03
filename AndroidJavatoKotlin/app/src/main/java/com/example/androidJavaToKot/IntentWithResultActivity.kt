package com.example.androidJavaToKot

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity


class IntentWithResultActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button

    //Using AndrioX API as StartActivityForResult is now deprecated
    //https://developer.android.com/training/basics/intents/result#custom
    //https://stackoverflow.com/questions/61455381/how-to-replace-startactivityforresult-with-activity-result-apis
    private var startActivityResultLauncher = registerForActivityResult(StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            // Here, no request code
            val intent = result.data
            val result: String? = intent?.getStringExtra("text")
            displayResult(result)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_with_result)
        button  = findViewById(R.id.IWR_button)
        button.setOnClickListener {
            enterText()
        }
    }


    private fun displayResult(result: String?) {
        textView = findViewById(R.id.IWR_textView)
        if (result != null) {
            textView.text = result
        } else textView.text = "No result"
    }

    private fun enterText() {
        val intent = Intent(this, SimpleResultReturnActivity::class.java)
        startActivityResultLauncher.launch(intent)
    }
}