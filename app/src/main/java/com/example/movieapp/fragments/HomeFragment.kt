package com.example.movieapp.fragments

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.movieapp.Movie
import com.example.movieapp.R
import com.example.movieapp.networking.MoviesCallBack
import com.example.movieapp.networking.MoviesNetworking
import com.squareup.picasso.Picasso
import kotlin.random.Random


class HomeFragment : Fragment() {

    lateinit var popular: View
    lateinit var upcoming: View
    lateinit var toprated: View
    lateinit var nowplaying: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.title).text = "Home"

        nowplaying = view.findViewById<ImageView>(R.id.nowPlaying)
        toprated = view.findViewById<ImageView>(R.id.topRated)
        popular = view.findViewById<ImageView>(R.id.popular)
        upcoming = view.findViewById<ImageView>(R.id.upcoming)


        getPoster("now_playing",nowplaying.findViewById<ImageView>(R.id.fragImg))
        getPoster("top_rated",toprated.findViewById<ImageView>(R.id.fragImg))
        getPoster("popular",popular.findViewById<ImageView>(R.id.fragImg))
        getPoster("upcoming",upcoming.findViewById<ImageView>(R.id.fragImg))

        nowplaying.findViewById<TextView>(R.id.fragText).text = "Now Playing"
        toprated.findViewById<TextView>(R.id.fragText).text = "Top Rated"
        popular.findViewById<TextView>(R.id.fragText).text = "Popular"
        upcoming.findViewById<TextView>(R.id.fragText).text = "Upcoming"



        nowplaying.setOnClickListener {
            trans("now_playing")
        }
        toprated.setOnClickListener {
            trans("top_rated")
        }
        popular.setOnClickListener {
            trans("popular")
        }
        upcoming.setOnClickListener {
            trans("upcoming")
        }


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

    fun trans(cat: String) {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, RecyclerFrag(cat))
            addToBackStack(null)
            commit()
        }
    }

    private fun getPoster(cat: String,current:ImageView){

        var movies: String?
        val moviesNetworking = MoviesNetworking(cat)
        val MoviesCallBack = object : MoviesCallBack {
            override fun onMoivesReady(movs: List<Movie>?) {
                val tmp =Random(System.currentTimeMillis()).nextInt(0,10)
                movies = movs?.get(tmp)?.image
                if(movies != null)
                    Picasso.get().load(movies).into(current)

            }
        }
        moviesNetworking.updateList(MoviesCallBack)

    }

}