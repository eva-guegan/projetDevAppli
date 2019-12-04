package com.example.projetappli.cocktail

import retrofit2.Call
import retrofit2.http.GET

interface CocktailWebService{
    @GET("/api/json/v1/1/random.php")
    fun getRandomCocktail(): Call<CocktailResponse>
}