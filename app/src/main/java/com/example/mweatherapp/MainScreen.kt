package com.example.mweatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

// Declaration of variable for three buttons and EditText
        val proview: Button =findViewById(R.id.view)
        val clear: Button =findViewById(R.id.clear)
        val exit: Button =findViewById(R.id.cancel)
        val max: EditText =findViewById(R.id.maximum)
        val mini: EditText =findViewById(R.id.minimum)
        val days: EditText =findViewById(R.id.day)
        val condi: EditText =findViewById(R.id.condition)

        // Set the on click lister of the button that will produce results
        proview.setOnClickListener {
            // Declaration of the arrays
            val DayArray =days.text.toString().split(",").map{it.trim()}.toTypedArray()
            val CondArray =condi.text.toString().split(",").map{it.trim()}.toTypedArray()
            val Minirray =mini.text.toString().split(",").map{it.trim()}.toTypedArray()
            val MaxArray =max.text.toString().split(",").map{it.trim()}.toTypedArray()
            //declare and create the array functionality
            val intent2= Intent(this,DetailScreen::class.java)
                //passing the arrays
                .apply { putExtra("Array Day",DayArray)
                    putExtra("Array Condition",CondArray)
                    putExtra("Array Minimum",Minirray)
                    putExtra("Array Maximum",MaxArray)

                    //Error Message Set up
                    val inputText=days.text.toString()
                    //Check if the input is empty
                    if (inputText.isEmpty()){
                        days.error="No day has been inputted"
                        condi.error="input a valid condition"
                        mini.error="please input a minimum"
                        max.error="please input a miximum"

                    }else{
                        //clear the input if valid
                        days.text.clear()
                        condi.text.clear()
                        mini.text.clear()
                        max.text.clear()

                    }
                }
            startActivity(intent2)

        }

// this button will clear everything written on the EditText
        clear.setOnClickListener {
            max.text.clear()
            mini.text.clear()
            days.text.clear()
            condi.text.clear()
        }
        // setting an onclick listener for exit button
        exit.setOnClickListener {
            System.exit(0)
        }
    }
}