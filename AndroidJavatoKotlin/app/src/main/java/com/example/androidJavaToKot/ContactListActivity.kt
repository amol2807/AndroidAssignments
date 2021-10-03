package com.example.androidJavaToKot

import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.Menu
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.loader.content.CursorLoader

class ContactListActivity : AppCompatActivity() {
    private val requestReadContacts = 1
    private var names: MutableList<String> = mutableListOf<String>()

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS)
            == PackageManager.PERMISSION_GRANTED
        ) {
            loadContacts()

        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_CONTACTS),
                requestReadContacts
            )
        }

        populateListView()
    }

    private fun populateListView() {
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, names)

        listView = findViewById(R.id.CL_listView)
        listView.adapter = adapter
        listView.onItemClickListener = OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, names[position], Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == requestReadContacts) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                loadContacts()
            } else {
                Toast.makeText(
                    this,
                    "Permission Denied, Not able to load contact",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
    }

    private fun loadContacts() {

        val contactsUri = Uri.parse("content://contacts/people")
        val cursorLoader = CursorLoader(this, contactsUri, null, null, null, null)
        val cursor = cursorLoader.loadInBackground()

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    val index = cursor.getColumnIndex(ContactsContract.Contacts._ID)
                    val contactID = cursor.getString(index)

                    //Get Name
                    val nameIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                    val contactDisplayName = cursor.getString(nameIndex)

                    Log.d("debug", "$contactID ,$contactDisplayName")

                } while (cursor.moveToNext())
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_contact_list, menu)
        return true
    }

}
