package com.jorzus.horoscoapp.domain

import com.jorzus.horoscoapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign:String):PredictionModel?
}