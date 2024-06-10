package com.example.mweatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // On click set up will take you to the next page or exit the Application

        enter.setOnClickListener {
            val intent1= Intent(this,MainScreen::class.java)
            startActivity(intent1) }

        exit.setOnClickListener {
            System.exit(0)
        }

    }
    //Declaration of the main buttons
    val enter: Button =findViewById(R.id.cButton)
    val exit: Button =findViewById(R.id.cancel)

}