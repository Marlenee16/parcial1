package com.example.parcial.repository

import com.example.parcial.data.model.FestivalModel

class FestivalRepository(private val festival: MutableList<FestivalModel>){

    fun getFestivals() = festival

    fun addFestival(newFestival: FestivalModel){
        festival.add(newFestival)
    }

}