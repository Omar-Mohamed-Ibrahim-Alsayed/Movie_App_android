package com.example.movieapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.movieapp.Movie
import com.example.movieapp.R
import com.squareup.picasso.Picasso

class DescribtionFragment(private val mov: Movie) : Fragment() {

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_describtion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieName = view.findViewById<TextView>(R.id.name)
        val logo = view.findViewById<ImageView>(R.id.poster)
        val moviedesc = view.findViewById<TextView>(R.id.description)
        val rate = view.findViewById<TextView>(R.id.rate)
        movieName.text= mov.name
        moviedesc.text= mov.describtion
        rate.text= mov.rate.toString()
        Picasso.get().load(mov.image).into(logo)


    }

}