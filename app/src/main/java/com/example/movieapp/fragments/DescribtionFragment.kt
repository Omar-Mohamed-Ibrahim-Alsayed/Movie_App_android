package com.example.movieapp.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import com.example.movieapp.Movie
import com.example.movieapp.R
import com.squareup.picasso.Picasso
import java.util.*

class DescribtionFragment(private val mov: Movie) : Fragment() {

    private lateinit var mySharedPreferences : SharedPreferences
    private lateinit var savedString : String
    private lateinit var ids : MutableList<Int>

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_describtion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieName = view.findViewById<TextView>(R.id.name)
        val logo = view.findViewById<ImageView>(R.id.poster)
        val moviedesc = view.findViewById<TextView>(R.id.description)
        val rate = view.findViewById<TextView>(R.id.rate)

        movieName.text= mov.name
        moviedesc.text= mov.describtion
        rate.text= mov.rate.toString()
        Picasso.get().load(mov.image).into(logo)



        mySharedPreferences=requireContext().getSharedPreferences("com.example.movieapp.favs", Context.MODE_PRIVATE)
        var isFav = checkFav()
        view.findViewById<ImageView>(R.id.favStar).setOnClickListener{

            if (isFav){
                ids.remove(mov.id)
                view?.findViewById<ImageView>(R.id.favStar)?.setImageResource(R.drawable.ic_fav_star)
                updateFavs()
            }
            else{
                ids.add(mov.id!!)
                view?.findViewById<ImageView>(R.id.favStar)?.setImageResource(R.drawable.ic_fav_star_selected)
                updateFavs()

            }

        }

    }

    fun checkFav() : Boolean{
        savedString = mySharedPreferences.getString("string", "").toString()
        val st  = StringTokenizer(savedString, ",")
        ids = mutableListOf<Int>()
        while (st.hasMoreTokens()) {
            ids.add(Integer.parseInt(st.nextToken()))
        }

        if(ids.contains(mov.id)){
            view?.findViewById<ImageView>(R.id.favStar)?.setImageResource(R.drawable.ic_fav_star_selected)
            return true
        }
        else{
            view?.findViewById<ImageView>(R.id.favStar)?.setImageResource(R.drawable.ic_fav_star)
            return false

        }

    }

    fun updateFavs(){
        val str = StringBuilder()

        ids.forEach { str.append(it).append(",") }

        mySharedPreferences.edit().putString("string",str.toString()).apply()

    }
}