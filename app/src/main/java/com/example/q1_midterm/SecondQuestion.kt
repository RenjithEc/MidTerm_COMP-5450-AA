package com.example.q1_midterm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondQuestion : AppCompatActivity(){
    override fun onCreate (savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val backButton : Button = findViewById(R.id.backButton2)


        val name : EditText = findViewById(R.id.editText1)
        val age : EditText = findViewById(R.id.editText2)
        val result: TextView = findViewById(R.id.textView6)
        val saveButton : Button = findViewById(R.id.saveButton)
        var value : String = ""


        var flag : String = "A+"
        val spinnerValue : Spinner = findViewById(R.id.spinner2)
//        var options = arrayOf("Sum","Subtract","Multiply","Divide")
        var options = arrayOf("A+","A-","B+","B-", "O+", "O-","AB+","AB-")
        spinnerValue.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)

        spinnerValue.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        saveButton.setOnClickListener {
            value = "Name: " + name.text.toString() + "\nAge: " + age.text.toString() + "\nBlood Group: " + flag
            result.text="Saved Information:\n\n $value"
        }

        backButton.setOnClickListener{
            val intent = Intent().apply {
                putExtra("result", value)
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}