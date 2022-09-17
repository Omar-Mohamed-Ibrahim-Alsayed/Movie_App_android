package com.example.movieapp.networking

import com.example.movieapp.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesNetworking(var category: String) {
    private val page = 1
    private val language = "en-US"
    private val apiKey = "7c10065a20413339fd17bcfc13346768"
    private val base_URL = "https://api.themoviedb.org"
    private val imgBase = "https://image.tmdb.org/t/p/w500"

    private val retrofit = Retrofit.Builder()
        .baseUrl(base_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val movieProcess = retrofit.create(MoviesServices::class.java)

    val call: Call<MovieResult> = movieProcess.getMovies(category,apiKey, language, page)

    //updateList(call)
    fun setCat(cat:String){
        this.category=cat
    }

    fun updateList(callBack: MoviesCallBack) {
        call.enqueue(object : Callback<MovieResult> {
            override fun onResponse(call: Call<MovieResult>, response: Response<MovieResult>) {
                val r = response.body()
                val final = r?.results
                val listOfMovies = final?.let { sortMovies(it) }
                callBack.onMoivesReady(listOfMovies)

            }

        override fun onFailure(call: Call<MovieResult>, t: Throwable) {
            t.printStackTrace()
        }
    })
}

private fun sortMovies(res: List<MovieResult.ResultsDTO>): List<Movie> {
    var movieList = mutableListOf<Movie>()
    res.forEach {
        movieList.add(Movie("${it.title}", "$imgBase${it.posterPath}", "\t${it.overview}",it.voteAverage))
    }
    return movieList
}

}