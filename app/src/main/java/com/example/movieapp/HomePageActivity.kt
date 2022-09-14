package com.example.movieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.delay

class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page)
        val b1=findViewById<Button>(R.id.startButton)
        val nameField=findViewById<EditText>(R.id.nameField)
        b1.setOnClickListener{
            val firstintent= Intent(this,MainActivity::class.java)
            firstintent.putExtra("Name",nameField.text.toString())
            startActivity(firstintent)

        }
    }
}