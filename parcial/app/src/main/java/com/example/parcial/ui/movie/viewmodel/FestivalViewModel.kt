package com.example.parcial.ui.movie.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.parcial.FestivalReviewerApplication
import com.example.parcial.data.model.FestivalModel
import com.example.parcial.repository.FestivalRepository

class FestivalViewModel (private val repository: FestivalRepository): ViewModel()  {

    var name = MutableLiveData("")
    var description = MutableLiveData("")
    var status = MutableLiveData("")
    fun getFestivals() = repository.getFestivals()

    fun addFestival(festival: FestivalModel) = repository.addFestival(festival)


    private fun validateData(): Boolean{
        when{
            name.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
        }
        return true
    }
    fun createFestival(){

        if(!validateData()){
            status.value = FESTIVAL_DELETED
            return
        }
        val newFestival = FestivalModel(
            name.value.toString(),
            description.value.toString(),
        )
        addFestival(newFestival)
        status.value = FESTIVAL_CREATED
    }

    fun setSelectedFestival(festival: FestivalModel){
        name.value = festival.name
        description.value = festival.description
    }



    fun clearData(){
        name.value = ""
        description.value = ""
   }

    fun clearStatus(){
        status.value = FESTIVAL_BASE
    }





    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as FestivalReviewerApplication
                FestivalViewModel(app.festivalRepository)
            }
        }

        const val FESTIVAL_CREATED = "festival created!"
        const val FESTIVAL_DELETED = "Festival WRONG DATA!"
        const val FESTIVAL_BASE = ""

    }
}