package com.example.movieapp.networking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesServices {
    @GET("/3/movie/popular")
    fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("language") lang: String,
        @Query("page") page: Int,
    ): Call<MovieResult>}