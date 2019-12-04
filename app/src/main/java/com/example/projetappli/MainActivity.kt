package com.example.projetappli

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.projetappli.cocktail.CocktailFragment
import com.example.projetappli.nasa.NasaFragment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            val fragment = NasaFragment()
            supportFragmentManager.beginTransaction().add(
                flexbox.id, fragment
            ).commit()
    }
}
