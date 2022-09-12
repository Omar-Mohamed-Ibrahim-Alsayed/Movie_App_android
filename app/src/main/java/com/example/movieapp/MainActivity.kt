package com.example.movieapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.networking.MovieResult
import com.example.movieapp.networking.MoviesServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var textview: TextView
    val page = 1
    val category = "popular"
    val language = "en-US"
    val apiKey = "7c10065a20413339fd17bcfc13346768"
    val base_URL = "https://api.themoviedb.org"
    val imgBase = "https://image.tmdb.org/t/p/w500"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textview = findViewById(R.id.temp)
        recyclerView = findViewById(R.id.rview)


        val retrofit = Retrofit.Builder()
            .baseUrl(base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val movieProcess = retrofit.create(MoviesServices::class.java)

        val call: Call<MovieResult> = movieProcess.getMovies(apiKey, language, page)

        updateList(call)

    }

    private fun updateList(call: Call<MovieResult>) {
        call.enqueue(object : Callback<MovieResult> {
            override fun onResponse(call: Call<MovieResult>, response: Response<MovieResult>) {
                val r = response.body()
                val final = r?.results
                val listOfMovies = final?.let { sortMovies(it) }
                val moviesAdapter = listOfMovies?.let { MovieAdaptor(it) }
                recyclerView.adapter = moviesAdapter
            }

            override fun onFailure(call: Call<MovieResult>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    private fun sortMovies(res: List<MovieResult.ResultsDTO>): List<Movie> {
        var movieList = mutableListOf<Movie>()
        res.forEach {
            movieList.add(Movie("${it.title}", "$imgBase${it.posterPath}", "\t${it.overview}"))
        }
        return movieList
    }

}