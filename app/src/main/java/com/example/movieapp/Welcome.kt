package com.example.movieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val handler= Handler(Looper.myLooper()!!)
        handler.postDelayed({
            val firstintent= Intent(this,HomePageActivity::class.java)
            startActivity(firstintent)
        },2000)
    }
}