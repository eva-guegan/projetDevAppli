package com.example.projetappli.nasa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projetappli.R
import com.example.projetappli.nasa.NasaWebService
import com.example.projetappli.nasa.NasaService
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.nasa.view.*
import kotlinx.android.synthetic.main.nasa.view.*

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NasaFragment : Fragment() {
    companion object {
        fun newInstance() = NasaFragment()
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater?.inflate(R.layout.nasa, container, false)
        return view
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://api.nasa.gov")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitService = retrofit.create(NasaWebService::class.java)
        val nasaService = NasaService(retrofitService)

        nasaService.getPictureOfTheDay(
            { nasa ->
                Picasso.get().load(nasa.hdurl).into(view.nasaImage)
                view.nasaName.text = nasa.title
            }, { error -> TODO() }
        )
    }

}