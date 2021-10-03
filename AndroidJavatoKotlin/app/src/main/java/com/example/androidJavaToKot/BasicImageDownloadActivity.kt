package com.example.androidJavaToKot

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.Menu
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.io.InputStream
import java.net.MalformedURLException
import java.net.URL
import java.net.URLConnection

class BasicImageDownloadActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_image_download)
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder().permitNetwork().build()
        )
        downloadImageFromUri("https://2.gravatar.com/avatar/858dfac47ab8176458c005414d3f0c36?s=128&d=&r=G")
    }

    private fun downloadImageFromUri(address: String) {
        var uri:URL?
        try{
            uri = URL(address)
        }catch (e: MalformedURLException){
            uri = null
            Log.v("BasicImageDownloadActivity", e.message.toString())
        }

        val conn : URLConnection
        val inputStream: InputStream
        var bitMap: Bitmap?
        try {
            Log.v("BasicImageDownloadActivity","Making Connection")
            conn= uri!!.openConnection()
            conn.connect()
            Log.v("BasicImageDownloadActivity"," Connection made")
            inputStream = conn.getInputStream()
            bitMap = BitmapFactory.decodeStream(inputStream)
            Log.v("BasicImageDownloadActivity"," Bitmap made")
            inputStream.close()
        }catch (e:IOException) {
            bitMap = null;
        }

        if (bitMap != null) {
            imageView = findViewById(R.id.ID_imageView)
            Log.v("BasicImageDownloadActivity"," Setting imageView")
            imageView.setImageBitmap(bitMap)
            Log.v("BasicImageDownloadActivity"," ImageViewset")

        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_basic_image_download, menu)
        return true
    }
}