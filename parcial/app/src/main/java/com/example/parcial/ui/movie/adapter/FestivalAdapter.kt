package com.example.parcial.ui.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial.data.model.FestivalModel
import com.example.parcial.databinding.FestivalItemBinding

class FestivalAdapter (private val clickListener: (FestivalModel) -> Unit): RecyclerView.Adapter<FestivalViewHolder>(){

    private val festivals = ArrayList<FestivalModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FestivalViewHolder {
        val binding = FestivalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FestivalViewHolder(binding)
    }

    override fun getItemCount(): Int = festivals.size

    override fun onBindViewHolder(holder: FestivalViewHolder, position: Int) {
        val festival = festivals[position]
        holder.bind(festival, clickListener)
    }

    fun setData(festivalsList: List<FestivalModel>){
        festivals.clear()
        festivals.addAll(festivalsList)
    }
}