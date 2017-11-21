package com.example.alancasas.recyclerview_cardview.ViewHolders

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.alancasas.recyclerview_cardview.Adapters.MyAdapter
import com.example.alancasas.recyclerview_cardview.Interfaces.CustomOnItemClickListener
import com.example.alancasas.recyclerview_cardview.Model.Movie
import com.example.alancasas.recyclerview_cardview.R
import com.squareup.picasso.Picasso

class CustomViewHolder (itemView: View, context: Context) : RecyclerView.ViewHolder(itemView){

    lateinit var customName: TextView
    lateinit var imageViewPoster: ImageView
    var context = context

    init {
        customName = itemView.findViewById(R.id.text_view_title)
        imageViewPoster = itemView.findViewById(R.id.image_view_poster)
    }

    fun bin (movie: Movie, listener: CustomOnItemClickListener){
        customName.text = movie.name
//        imageViewPoster.setImageResource(movie.poster)
        Picasso.with(context).load(movie.poster).fit().into(imageViewPoster)

        itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {
                listener.onCustomItemClickListener(movie, adapterPosition)
            }
        })
    }

}