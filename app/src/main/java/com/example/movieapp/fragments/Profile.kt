package com.example.movieapp.fragments

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.movieapp.MainActivity
import com.example.movieapp.R

class Profile : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val logIn=requireView().findViewById<Button>(R.id.startButton)
        val nameField=requireView().findViewById<EditText>(R.id.nameField)
        logIn.setOnClickListener{
            val mediaPlayer=MediaPlayer.create(requireContext(),R.raw.login)
            mediaPlayer.start()
            fragmentManager?.popBackStack()

        }
    }

}