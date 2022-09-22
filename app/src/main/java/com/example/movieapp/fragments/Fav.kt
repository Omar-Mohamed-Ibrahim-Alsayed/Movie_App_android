package com.example.movieapp.fragments

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.edit
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.Movie
import com.example.movieapp.MovieAdaptor
import com.example.movieapp.R
import com.example.movieapp.networking.MoviesCallBack
import com.example.movieapp.networking.MoviesNetworking
import com.example.movieapp.networking.favMovieNetworking
import java.util.*

class Fav : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var favs: MutableList<Movie>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView = requireView().findViewById(R.id.favRR)

        val mySharedPreferences =
            requireContext().getSharedPreferences("com.example.movieapp.favs", Context.MODE_PRIVATE)
        val savedString: String = mySharedPreferences.getString("string", "").toString()
        val st = StringTokenizer(savedString, ",")
        val ids = mutableListOf<Int>()
        while (st.hasMoreTokens()) {
            ids.add(Integer.parseInt(st.nextToken()))
        }


        favs = mutableListOf<Movie>()

        ids.forEach {
            val moviesNetworking = favMovieNetworking(it)
            val MoviesCallBack = object : MoviesCallBack {

                override fun onMoivesReady(movs: List<Movie>?) {
                }

                override fun onMoiveReady(movs: Movie?) {
                    if (movs != null) {
                        favs.add(movs)
                        val moviesAdapter = MovieAdaptor(favs, parentFragmentManager)
                        recyclerView.adapter = moviesAdapter

                    }
                }
            }

            moviesNetworking.updateList(MoviesCallBack)

        }


        // Profile Button

        val profile = requireView().findViewById<ImageView>(R.id.profile)
        profile.setOnClickListener {
            val mediaPlayer = MediaPlayer.create(requireContext(), R.raw.logout2)
            mediaPlayer.start()
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, Profile())
                addToBackStack(null)
                commit()
            }
        }


        //homeButton

        val home = requireView().findViewById<ImageView>(R.id.homeicon)
        home.setOnClickListener {
            val mediaPlayer = MediaPlayer.create(requireContext(), R.raw.logout2)
            mediaPlayer.start()
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, HomeFragment())
                addToBackStack(null)
                commit()
            }
        }

        //logout Button

        val logout = requireView().findViewById<ImageView>(R.id.logout)
        logout.setOnClickListener {
            val mediaPlayer = MediaPlayer.create(requireContext(), R.raw.logout2)
            mediaPlayer.start()
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, Profile())
                addToBackStack(null)
                commit()
            }
        }

    }
}