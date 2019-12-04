package com.example.projetappli.nasa

import android.widget.DatePicker
import java.util.*

data class Nasa(
    val date: Date,
    val api_key: String,
    val url: String,
    val title: String,
    val explanation: String
)