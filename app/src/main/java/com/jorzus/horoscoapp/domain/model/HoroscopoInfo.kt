package com.jorzus.horoscoapp.domain.model

import com.jorzus.horoscoapp.R

sealed class HoroscopoInfo(val name: Int, val image: Int) {
    data object Aries : HoroscopoInfo(R.string.aries, R.drawable.aries)
    data object Taurus : HoroscopoInfo(R.string.taurus, R.drawable.tauro)
    data object Gemini : HoroscopoInfo(R.string.gemini, R.drawable.geminis)
    data object Cancer : HoroscopoInfo(R.string.cancer, R.drawable.cancer)
    data object Leo : HoroscopoInfo(R.string.leo, R.drawable.leo)
    data object Virgo : HoroscopoInfo(R.string.virgo, R.drawable.virgo)
    data object Libra : HoroscopoInfo(R.string.libra, R.drawable.libra)
    data object Scorpio : HoroscopoInfo(R.string.scorpio, R.drawable.escorpio)
    data object Sagittarius : HoroscopoInfo(R.string.sagittarius, R.drawable.sagitario)
    data object Capricorn : HoroscopoInfo(R.string.capricorn, R.drawable.capricornio)
    data object Aquarius : HoroscopoInfo(R.string.aquarius, R.drawable.aquario)
    data object Pisces : HoroscopoInfo(R.string.pisces, R.drawable.piscis)
}