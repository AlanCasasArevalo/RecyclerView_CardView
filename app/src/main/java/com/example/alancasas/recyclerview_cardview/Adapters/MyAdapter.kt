package com.example.alancasas.recyclerview_cardview.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.alancasas.recyclerview_cardview.Interfaces.CustomOnItemClickListener
import com.example.alancasas.recyclerview_cardview.Model.Movie
import com.example.alancasas.recyclerview_cardview.ViewHolders.CustomViewHolder

class MyAdapter (movies: ArrayList<Movie>, customLayout: Int, listener: CustomOnItemClickListener) : RecyclerView.Adapter<CustomViewHolder>() {

    var movies: ArrayList<Movie> = movies
    var customLayout: Int = customLayout
    var itemClickListener :CustomOnItemClickListener = listener
    var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder? {
        var customView = LayoutInflater.from(parent?.context).inflate(customLayout, parent, false)
        if (parent != null) {
            context = parent.context
        }
        return context?.let { CustomViewHolder(customView, it) }
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        holder?.bin(movies[position], itemClickListener)
    }

    override fun getItemCount(): Int = movies.size
}