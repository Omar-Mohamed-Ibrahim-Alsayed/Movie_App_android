package com.example.movieapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class Description : AppCompatActivity(){
    private  var context : Context = this
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.description)

            val logo: ImageView = findViewById(R.id.poster)
            val name: TextView = findViewById(R.id.name)
            val description : TextView = findViewById(R.id.description)

            name.text =intent.getStringExtra("name")
            description.text =intent.getStringExtra("desc")
            Picasso.with(context).load(intent.getStringExtra("logo")).into(logo)
        }
    }
