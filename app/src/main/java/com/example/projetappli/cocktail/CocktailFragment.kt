package com.example.projetappli.cocktail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projetappli.R
import com.example.tpepsihttp.cocktail.CocktailService
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cocktail.view.*

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CocktailFragment : Fragment() {
    companion object {
        fun newInstance() = CocktailFragment()
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater?.inflate(R.layout.cocktail, container, false)
        return view
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://nasaapidimasv1.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitService = retrofit.create(CocktailWebService::class.java)
        val cocktailService = CocktailService(retrofitService)

        cocktailService.getRandomCocktail(
            { cocktail ->
                Picasso.get().load(cocktail.strDrinkThumb).into(view.cocktailImage)
                view.cocktailName.text = cocktail.strDrink
            }, { error -> TODO() }
        )
    }

}