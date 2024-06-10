package com.example.mweatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//Get the Array elements from the MainScreen Activity
        val DayArray = intent.getStringArrayExtra("Array Day") ?: arrayOf()
        val CondArray = intent.getStringArrayExtra("Array Condition") ?: arrayOf()
        val Minirray = intent.getStringArrayExtra("Array Minimum") ?: arrayOf()
        val MaxArray = intent.getStringArrayExtra("Array Maximum") ?: arrayOf()

        //TextView Declaration
        val max: TextView = findViewById(R.id.text3)
        val mini: TextView = findViewById(R.id.text4)
        val days: TextView = findViewById(R.id.text2)
        val condi: TextView = findViewById(R.id.View5)

        //Display on the text view
        days.text = "Day List\n${DayArray.joinToString("\n")}"
        condi.text = "Conditions\n${CondArray.joinToString("\n")}"
        mini.text = "Minimun Temp\n${Minirray.joinToString("\n")}"
        max.text = "Maximum Temp\n${MaxArray.joinToString("\n")}"

        // Declaration of the home and On click set up will take you to the home page
        val home: Button = findViewById(R.id.home)
        home.setOnClickListener {
            val intent3= Intent(this,MainActivity::class.java)
            startActivity(intent3) }

    }
}