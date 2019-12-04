package com.example.projetappli.nasa

import com.example.projetappli.nasa.NasaResponse
import retrofit2.Call
import retrofit2.http.POST

interface NasaWebService{
    @POST("/planetary/apod")
    fun getPictureOfTheDay(): Call<Nasa>
}