package com.example.q1_midterm

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdQuestion: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val value1 = intent.getStringExtra("firstQuestion")
        val value2 = intent.getStringExtra("secondQuestion")

        val backButton: Button = findViewById(R.id.backButtonThird)
        val seeResultButton: Button = findViewById(R.id.thirdResultButton)
        val result1: TextView = findViewById(R.id.firstResultText)
        val result2: TextView = findViewById(R.id.secondResultText)

        seeResultButton.setOnClickListener {
            result1.text = "Result from First Question: \n$value1"
            result2.text = "Result from Second Question: \n$value2"
        }

        backButton.setOnClickListener{
            finish()
        }
    }
}