package com.example.parcial

import android.app.Application
import com.example.parcial.data.festival
import com.example.parcial.repository.FestivalRepository

class FestivalReviewerApplication: Application () {

    val festivalRepository: FestivalRepository by lazy {
        FestivalRepository(festival)
    }
}