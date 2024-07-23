package com.example.q1_midterm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE_FIRST = 1
    private val REQUEST_CODE_SECOND = 2
    private val REQUEST_CODE_THIRD = 3
    private var firstResult: String = ""
    private var secondResult: String = ""
    private var isFirstExecuted: Boolean = false
    private var isSecondExecuted: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val q1button : Button = findViewById(R.id.button1)
        val q2button : Button = findViewById(R.id.button2)
        val q3button : Button = findViewById(R.id.button3)

        q1button.setOnClickListener {
            val intent = Intent(this, FirstQuestion::class.java)
            startActivityForResult(intent,REQUEST_CODE_FIRST)
        }

        q2button.setOnClickListener {
            val intent = Intent(this, SecondQuestion::class.java)
            startActivityForResult(intent,REQUEST_CODE_SECOND)
        }

        q3button.setOnClickListener {
            if (!isFirstExecuted){
                firstResult = "First Question not executed. Please execute and return"
            }
            if (!isSecondExecuted){
                secondResult = "Second Question not executed. Please execute and return"
            }
            val intent = Intent(this, ThirdQuestion::class.java).apply {
                putExtra("firstQuestion", firstResult)
                putExtra("secondQuestion", secondResult)
            }
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_FIRST && resultCode == Activity.RESULT_OK) {
            val result = data?.getStringExtra("result")
            if (result != null) {
                firstResult = result.toString()
                isFirstExecuted = true
            }
        } else if (requestCode == REQUEST_CODE_SECOND && resultCode == Activity.RESULT_OK) {
            val result = data?.getStringExtra("result")
            if (result != null) {
                secondResult = result.toString()
                isSecondExecuted = true
            }
        }
    }

}