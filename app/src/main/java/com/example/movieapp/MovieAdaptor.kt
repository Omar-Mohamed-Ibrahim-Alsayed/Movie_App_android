package com.example.movieapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MovieAdaptor(private val movies : List<Movie>) : RecyclerView.Adapter<MovieAdaptor.MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemMovieView = LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false)
        return MovieViewHolder(itemMovieView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val current = movies[position]
        holder.bind(current)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class MovieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView
        private val image: ImageView

        init{
            name = itemView.findViewById(R.id.movieName)
            image = itemView.findViewById(R.id.movieLogo)
            itemView.setOnClickListener{
                val current = movies[layoutPosition]
                val intent = Intent(itemView.context,Description::class.java)
                intent.putExtra("name",current.name)
                intent.putExtra("logo",current.image)
                intent.putExtra("desc",current.describtion)
                itemView.context.startActivity(intent)
            }
        }

        fun bind(movie: Movie) {
            name.text = movie.name
            image.setImageResource(movie.image)
        }
    }

}