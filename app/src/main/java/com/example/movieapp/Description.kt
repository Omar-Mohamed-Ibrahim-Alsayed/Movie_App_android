package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Description : AppCompatActivity(){
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.description)

            val logo: ImageView = findViewById(R.id.poster)
            val name: TextView = findViewById(R.id.name)
            val description : TextView = findViewById(R.id.description)

            name.text =intent.getStringExtra("name")
            description.text =intent.getStringExtra("desc")
            logo.setImageResource(intent.getIntExtra("logo",0))
        }
    }
