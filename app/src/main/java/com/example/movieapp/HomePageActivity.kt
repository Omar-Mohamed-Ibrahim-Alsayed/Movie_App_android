package com.example.movieapp

import android.content.Intent
import android.media.MediaPlayer
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
        val logIn=findViewById<Button>(R.id.startButton)
        val nameField=findViewById<EditText>(R.id.nameField)
        logIn.setOnClickListener{
            val mediaPlayer=MediaPlayer.create(this,R.raw.login)
            mediaPlayer.start()
            val firstintent= Intent(this,MainActivity::class.java)
            firstintent.putExtra("Name",nameField.text.toString())
            startActivity(firstintent)

        }
    }
}