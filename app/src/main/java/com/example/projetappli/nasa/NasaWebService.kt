package com.example.projetappli.nasa

import com.example.projetappli.nasa.NasaResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface NasaWebService{
    @GET("/planetary/apod?api_key=DEMO_KEY")
    fun getPictureOfTheDay(): Call<Nasa>
}