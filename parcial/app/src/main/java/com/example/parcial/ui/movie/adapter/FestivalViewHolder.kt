package com.example.parcial.ui.movie.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.parcial.data.model.FestivalModel
import com.example.parcial.databinding.FestivalItemBinding

class FestivalViewHolder (private val binding: FestivalItemBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(festival: FestivalModel, clickListener: (FestivalModel) -> Unit){

        binding.festivalName.text = festival.name


    }
}