package com.example.movieapp.fragments

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.movieapp.R

class StartupFragment() : Fragment() {

    private lateinit var mediaPlayer:MediaPlayer


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_startup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val stb= AnimationUtils.loadAnimation(view.context,R.anim.stb)
        val handler= Handler(Looper.myLooper()!!)
        val welcomeImage=view.findViewById<ImageView>(R.id.welcomeImage)


        welcomeImage.startAnimation(stb)
        welcomeImage.setOnClickListener{
            welcomeImage.animate().cancel()
            mediaPlayer.stop()
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, HomeFragment())
                addToBackStack(null)
                commit()
            }
        }
        mediaPlayer= MediaPlayer.create(view.context,R.raw.startup)
        mediaPlayer.start()
        welcomeImage.animate().apply {
            duration=3000
            rotationYBy(0f)
        }.withEndAction {
            handler.postDelayed({
                mediaPlayer.stop()
                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.flFragment, HomeFragment())
                    commit()
                }
            },500)
        }


    }

    }

