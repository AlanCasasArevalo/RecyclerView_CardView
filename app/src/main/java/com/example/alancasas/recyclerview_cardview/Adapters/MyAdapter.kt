package com.example.alancasas.recyclerview_cardview.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.alancasas.recyclerview_cardview.Interfaces.CustomOnItemClickListener
import com.example.alancasas.recyclerview_cardview.ViewHolders.CustomViewHolder

class MyAdapter (names: ArrayList<String>, customLayout: Int, listener: CustomOnItemClickListener) : RecyclerView.Adapter<CustomViewHolder>() {

    var names: ArrayList<String> = names
    var customLayout: Int = customLayout
    var itemClickListener :CustomOnItemClickListener = listener

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        var customView = LayoutInflater.from(parent?.context).inflate(customLayout, parent, false)
        return CustomViewHolder(customView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        holder?.bin(names[position], itemClickListener)
    }

    override fun getItemCount(): Int = names.size
}