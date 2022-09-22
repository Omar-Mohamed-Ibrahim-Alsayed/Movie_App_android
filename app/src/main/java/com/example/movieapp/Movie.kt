package com.example.movieapp

import android.os.Parcel
import android.os.Parcelable

data class Movie(
    val name: String?,
    val id: Int?,
    val image: String?,
    val describtion: String?,
    val rate : Number?
)  {

}