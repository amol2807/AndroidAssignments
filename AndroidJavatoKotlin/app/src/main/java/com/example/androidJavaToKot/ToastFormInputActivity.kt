 package com.example.androidJavaToKot

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ToastFormInputActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var checkbox: CheckBox
    private lateinit var radio: RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast_form_input)

        editText = findViewById(R.id.TI_input)
        checkbox = findViewById(R.id.TI_checkBox)
        radio = findViewById(R.id.TI_rdg)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_toast_form_inputs, menu)
        return true
    }

    fun toastInputs(view: View?){
        val selected =radio.checkedRadioButtonId
        val radioButton  = findViewById<RadioButton>(selected)
        val text =editText.text.toString() + "|"+ checkbox.isChecked +"|"+ radioButton.text
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}