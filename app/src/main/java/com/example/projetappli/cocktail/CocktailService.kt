package com.example.tpepsihttp.cocktail

import com.example.projetappli.cocktail.Cocktail
import com.example.projetappli.cocktail.CocktailResponse
import com.example.projetappli.cocktail.CocktailWebService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CocktailService constructor(
    private val webservice: CocktailWebService
) {
    fun getRandomCocktail( onDone: (Cocktail)->Unit, onError: (Throwable)->Unit ) {
        webservice.getRandomCocktail().enqueue(object : Callback<CocktailResponse> {
            override fun onResponse(
                call: Call<CocktailResponse>,
                response: Response<CocktailResponse>
            ) {
                val cocktailResponse =  response.body()
                val cocktail: Cocktail = cocktailResponse!!.drinks[0]
                onDone(cocktail)
            }
            override fun onFailure(call: Call<CocktailResponse>, t: Throwable) {
                onError(t)
            }
        })
    }
}