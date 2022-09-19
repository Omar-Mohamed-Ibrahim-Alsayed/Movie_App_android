package com.example.movieapp.fragments

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.*
import com.example.movieapp.networking.MoviesCallBack
import com.example.movieapp.networking.MoviesNetworking


class RecyclerFrag(val cat : String) : Fragment() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var over: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        over = inflater.inflate(R.layout.fragment_recycler2, container, false)
        return over
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.title).text = "$cat"


        recyclerView = requireView().findViewById(R.id.rview)

        val moviesNetworking = MoviesNetworking(cat)
        val MoviesCallBack = object : MoviesCallBack {
            override fun onMoivesReady(movs: List<Movie>?) {
                val moviesAdapter = movs?.let { MovieAdaptor(movs, parentFragmentManager) }
                recyclerView.adapter = moviesAdapter
            }
        }
        moviesNetworking.updateList(MoviesCallBack)

        // Profile Button

        val profile=requireView().findViewById<ImageView>(R.id.profile)
        profile.setOnClickListener{
            val mediaPlayer= MediaPlayer.create(requireContext(),R.raw.logout2)
            mediaPlayer.start()
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, Profile())
                addToBackStack(null)
                commit()
            }
        }

        //favourites Button

        val favourites=requireView().findViewById<ImageView>(R.id.favourites)
        favourites.setOnClickListener{
            val mediaPlayer= MediaPlayer.create(requireContext(),R.raw.logout2)
            mediaPlayer.start()
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, Profile())
                addToBackStack(null)
                commit()
            }
        }

        //homeButton

        val home=requireView().findViewById<ImageView>(R.id.homeicon)
        home.setOnClickListener{
            val mediaPlayer= MediaPlayer.create(requireContext(),R.raw.logout2)
            mediaPlayer.start()
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, Profile())
                addToBackStack(null)
                commit()
            }
        }

        //logout Button

        val logout=requireView().findViewById<ImageView>(R.id.logout)
        logout.setOnClickListener{
            val mediaPlayer= MediaPlayer.create(requireContext(),R.raw.logout2)
            mediaPlayer.start()
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, Profile())
                addToBackStack(null)
                commit()
            }
        }

    }

    }

