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

class FirstQuestion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_first)

        val backButton: Button = findViewById(R.id.backButton1)

        val num1 : EditText = findViewById(R.id.editTextNumber1)
        val num2 : EditText = findViewById(R.id.editTextNumber2)
        val result: TextView = findViewById(R.id.textView3)
        val calButton : Button = findViewById(R.id.addButton)
        var finalAnswer : Int = 0;

        var flag : String = "Sum"
        val spinnerValue : Spinner = findViewById(R.id.spinner1)
//        var options = arrayOf("Sum","Subtract","Multiply","Divide")
        var options = arrayOf("Add","Subtract","Divide","Multiply")
        spinnerValue.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)

        spinnerValue.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        calButton.setOnClickListener{_ ->
            var x: Int = num1.text.toString().toInt();
            var y: Int = num2.text.toString().toInt();
            var value: Int = 0;

            when (flag){
                "Add" -> value = add(x,y)
                "Subtract" -> value =  sub(x,y)
                "Multiply" -> value =  mul(x,y)
                "Divide" -> value =  div(x,y)
            }
            finalAnswer = value
            result.text = "Result: $finalAnswer"

        }

        backButton.setOnClickListener{
            val intent = Intent().apply {
                putExtra("result", finalAnswer.toString())
            }
            println("Final Answer put:  $finalAnswer")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
    private fun add(a: Int, b: Int): Int{
        return a+b;
    }

    private fun sub(a: Int, b: Int): Int{
        return a-b;
    }

    private fun mul(a: Int, b: Int): Int{
        return a*b;
    }

    private fun div(a: Int, b: Int): Int{
        return a/b;
    }

}