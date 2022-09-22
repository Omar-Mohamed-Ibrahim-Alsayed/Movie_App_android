package com.example.movieapp.networking

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.movieapp.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class favMovieNetworking (id : Int){

        private val base_URL = "https://api.themoviedb.org"
        private val imgBase = "https://image.tmdb.org/t/p/w500"
        private val apiKey = "7c10065a20413339fd17bcfc13346768"
        private val movId = id


    private val retrofit = Retrofit.Builder()
            .baseUrl(base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        private val movieProcess = retrofit.create(MoviesServices::class.java)

        val call: Call<favResult> = movieProcess.getMovie(movId,apiKey,"en-US")


    fun updateList(callBack: MoviesCallBack) {


            call.enqueue(object : Callback<favResult> {
                override fun onResponse(call: Call<favResult>, response: Response<favResult>) {
                    val r = response.body()
                    val goal = Movie(r?.originalTitle, r?.id,"$imgBase${r?.posterPath}",
                        r?.overview, r?.voteAverage
                    )
                    callBack.onMoiveReady(goal)

                }

                override fun onFailure(call: Call<favResult>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        }




    }
