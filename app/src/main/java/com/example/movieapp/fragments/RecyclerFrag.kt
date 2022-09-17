package com.example.movieapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.Movie
import com.example.movieapp.MovieAdaptor
import com.example.movieapp.R
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

        recyclerView = requireView().findViewById(R.id.rview)

        val moviesNetworking = MoviesNetworking(cat)
        val MoviesCallBack = object : MoviesCallBack {
            override fun onMoivesReady(movs: List<Movie>?) {
                val moviesAdapter = movs?.let { MovieAdaptor(movs, parentFragmentManager) }
                recyclerView.adapter = moviesAdapter
            }
        }
        moviesNetworking.updateList(MoviesCallBack)


    }

    }

