package com.example.alancasas.recyclerview_cardview.ViewHolders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.alancasas.recyclerview_cardview.Interfaces.CustomOnItemClickListener
import com.example.alancasas.recyclerview_cardview.R

class CustomViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

    lateinit var customName: TextView

    init {
        customName = itemView.findViewById(R.id.custom_text_view)
    }

    fun bin ( name:String, listener: CustomOnItemClickListener){
        customName.text = name
        itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                listener.onCustomItemClickListener(name, adapterPosition)
            }
        })
    }

}