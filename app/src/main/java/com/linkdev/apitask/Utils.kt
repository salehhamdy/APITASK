package com.linkdev.apitask

fun String?.fullImageURL():String?{

   val fullURL= if (!isNullOrEmpty())
        "https://image.tmdb.org/t/p/w500/$this"

   else
        this

    return fullURL

}