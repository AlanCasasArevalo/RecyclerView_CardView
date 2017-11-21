package com.example.alancasas.recyclerview_cardview.Interfaces

import com.example.alancasas.recyclerview_cardview.Model.Movie

interface CustomOnItemClickListener {
    fun onCustomItemClickListener(movie: Movie, position: Int)
}