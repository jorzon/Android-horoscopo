package com.jorzus.horoscoapp.data

import android.util.Log
import com.jorzus.horoscoapp.data.network.HoroscopoApiService
import com.jorzus.horoscoapp.domain.Repository
import com.jorzus.horoscoapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopoApiService): Repository {

    override suspend fun getPrediction(sign: String):PredictionModel? {
        //llamar retrofit
        //ejecutar una tarea
       return runCatching {
           val response = apiService.getHoroscopo(sign)
           if (response.isSuccessful) {
               response.body()?.toDomain()
           } else {
               Log.i("mensaje", "Error en la respuesta: ${response.code()}")
               null
           }
       }.onFailure {
            Log.i("mensaje", "fallo ${it.message}")
        }.getOrNull()

    }


}