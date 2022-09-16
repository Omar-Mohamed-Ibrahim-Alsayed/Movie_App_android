package com.example.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.fragments.DescribtionFragment
import com.squareup.picasso.Picasso


 class MovieAdaptor(private val movies : List<Movie>, private val fragmentManager : FragmentManager) : RecyclerView.Adapter<MovieAdaptor.MovieViewHolder>() {


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
                fragmentManager.beginTransaction().apply {
                    replace(R.id.flFragment, DescribtionFragment(current))
                    addToBackStack(null)
                    commit()
                }
            }
        }

        fun bind(movie: Movie) {
            name.text = movie.name
            Picasso.get().load(movie.image).into(image)
        }
    }

}