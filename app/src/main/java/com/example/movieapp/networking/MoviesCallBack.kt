package com.example.movieapp.networking

import com.example.movieapp.Movie

interface MoviesCallBack {
    fun onMoivesReady(movs : List<Movie>?)
}