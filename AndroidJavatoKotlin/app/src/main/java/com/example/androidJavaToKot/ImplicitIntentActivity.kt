package com.example.androidJavaToKot

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ImplicitIntentActivity : AppCompatActivity() {

    private lateinit var uri:String
    private lateinit var editText: EditText
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)
        button = findViewById(R.id.II_button)

        button.setOnClickListener {
            visitUrl()
        }

    }

    private fun visitUrl() {
        val URI  = getUrl()
        if(URI!=null){
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = URI
            startActivity(intent)
        }
    }

    private fun getUrl(): Uri? {

        editText = findViewById(R.id.II_url_editText)
        uri  = editText.text.toString()
        Log.v("IntentActivity",uri)
        if(uri!=null){
            if(!uri.startsWith("https://")){
                uri = "https://$uri"
                return Uri.parse(uri)
            }
        }
        return null
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_implicit_intent,menu)
        return true
    }
}