package com.example.parcial.repository

import com.example.parcial.data.festival
import com.example.parcial.data.model.FestivalModel

class FestivalRepository(private val movies: MutableList<FestivalModel>){

    fun getFestival() = festival

    fun addFestival(newFestival: FestivalModel){
        festival.add(newFestival)
    }

}