package com.jorzus.horoscoapp.data.network.response

import com.google.gson.annotations.SerializedName
import com.jorzus.horoscoapp.domain.model.PredictionModel

data class PredictionResponse(
    @SerializedName("date")  val date: String,
    @SerializedName("sign") val sign: String,
    @SerializedName("horoscope") val horoscope:String
    ) {
    fun toDomain():PredictionModel{
        return PredictionModel(horoscope = horoscope, sign =  sign , date = date)
    }
}


//{
//    "date": "2025-04-09",
//    "horoscope": "Apr 8, 2025 - Money may be coming your way through a contract of some kind. This is a positive development. Make sure you read every word in the document before you commit to anything. This is a good time to ask for a loan or fill out paperwork regarding scholarships, grants, or other forms of financial support. The process is going to be less complicated than you imagined, Taurus. Things should manifest quickly.",
//    "icon": "https://newastro.vercel.app/static/assets/zodiac-2.png",
//    "id": 2,
//    "sign": "Taurus"
//}