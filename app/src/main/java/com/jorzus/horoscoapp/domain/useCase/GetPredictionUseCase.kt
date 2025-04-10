package com.jorzus.horoscoapp.domain.useCase

import com.jorzus.horoscoapp.domain.Repository
import com.jorzus.horoscoapp.domain.model.PredictionModel
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sign:String): PredictionModel? {
        return repository.getPrediction(sign)
    }
}