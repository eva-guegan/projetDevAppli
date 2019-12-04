package com.example.projetappli.nasa


import com.example.projetappli.nasa.Nasa
import com.example.projetappli.nasa.NasaFragment
import com.example.projetappli.nasa.NasaResponse
import com.example.projetappli.nasa.NasaWebService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NasaService constructor(
    private val webservice: NasaWebService
) {
    fun getPictureOfTheDay( onDone: (Nasa)->Unit, onError: (Throwable)->Unit ) {
        webservice.getPictureOfTheDay().enqueue(object : Callback<Nasa> {
            override fun onResponse(
                call: Call<Nasa>,
                response: Response<Nasa>
            ) {
                val nasa =  call
                val nasa: Nasa = nasa.
                onDone(nasa)
            }
            override fun onFailure(call: Call<NasaResponse>, t: Throwable) {
                onError(t)
            }
        })
    }
}