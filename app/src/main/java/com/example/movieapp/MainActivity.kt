package com.example.movieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.movieapp.fragments.RecyclerFrag
import com.example.movieapp.fragments.StartupFragment

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, StartupFragment())
            commit()
        }



    }
}