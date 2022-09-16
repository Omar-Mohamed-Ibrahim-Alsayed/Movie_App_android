package com.example.movieapp

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class Welcome : AppCompatActivity() {
    private lateinit var mediaPlayer:MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val stb=AnimationUtils.loadAnimation(this,R.anim.stb)
        val handler= Handler(Looper.myLooper()!!)
        val welcomeImage=findViewById<ImageView>(R.id.welcomeImage)
        welcomeImage.startAnimation(stb)
        welcomeImage.setOnClickListener{
            welcomeImage.animate().cancel()
            mediaPlayer.stop()
            val firstintent= Intent(this,HomePageActivity::class.java)
            startActivity(firstintent)
        }
        mediaPlayer=MediaPlayer.create(this,R.raw.clapping)
        mediaPlayer.start()
            welcomeImage.animate().apply {
                duration=3000
                rotationYBy(0f)
            }.withEndAction {
                handler.postDelayed({
                    mediaPlayer.stop()
                    val firstintent= Intent(this,HomePageActivity::class.java)
                    startActivity(firstintent)
                },500)
            }


    }
}