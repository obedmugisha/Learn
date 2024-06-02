package com.example.learn

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learn.R.layout.activity_main

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(activity_main)
        val greetingTextView = findViewById<TextView>(R.id.welcome)
        val inputField = findViewById<EditText>(R.id.editTextText)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val offersBtn = findViewById<Button>(R.id.OffersBtn)
        var EnteredName = ""
        btnSubmit.setOnClickListener {

            val EnteredName = inputField.text.toString()
            if (EnteredName == "") {
                greetingTextView.text = ""
                Toast.makeText( this@MainActivity,"Please Enter your Name", Toast.LENGTH_SHORT).show()
                offersBtn.visibility = INVISIBLE
            } else {
                val message = "$EnteredName Welcome To Android App Development Program"
                greetingTextView.text = message
                inputField.text.clear()
                offersBtn.visibility = VISIBLE
            }
            offersBtn.setOnClickListener{
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("USER",EnteredName)
                startActivity(intent)
        }


        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}