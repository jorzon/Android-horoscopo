package com.jorzus.horoscoapp.ui.detail

import com.jorzus.horoscoapp.domain.model.HoroscopoModel

sealed class DetailState {
    data object Loading : DetailState()
    data class Error(val error: String) : DetailState()
    data class Success(val prediction: String , val name:String , val horoscopoModel: HoroscopoModel) : DetailState()
}