package com.example.androidJavaToKot

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AsyncTaskPerformActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task_perform)
        MyAsyncTask(this).execute()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_async_task_perform, menu)
        return true
    }

    private fun doneCounting() {
        Toast.makeText(this, "Counting to 100000", Toast.LENGTH_SHORT).show()
    }

    private class MyAsyncTask(context:Context): AsyncTask<Void?, Void?, Void?>() {

        override fun onPostExecute(result: Void?) {
//            context.doneCounting()
        }

        override fun doInBackground(vararg p0: Void?): Void? {
            for (i in 0..99999) {
                println(i)
            }
            return null
        }
    }
}