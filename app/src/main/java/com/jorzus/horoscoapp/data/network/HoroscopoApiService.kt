package com.jorzus.horoscoapp.data.network

import com.jorzus.horoscoapp.data.network.response.PredictionResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopoApiService {

    @GET("/{name}")
    suspend fun getHoroscopo(@Path("name") sign: String): Response<PredictionResponse>

//sign --> puede ser cualquier nombre, solo lo que esta lo que esta dentro de las {}, ves igual en el path

    //la peticion trae uan respuesta, ahi en el tipo de respuesta le tenemos que mandar la data class que creamos con el formato que vendra

}