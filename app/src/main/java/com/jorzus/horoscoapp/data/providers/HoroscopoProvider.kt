package com.jorzus.horoscoapp.data.providers

import com.jorzus.horoscoapp.domain.model.HoroscopoInfo
import com.jorzus.horoscoapp.domain.model.HoroscopoInfo.Aquarius
import com.jorzus.horoscoapp.domain.model.HoroscopoInfo.Aries
import com.jorzus.horoscoapp.domain.model.HoroscopoInfo.Cancer
import com.jorzus.horoscoapp.domain.model.HoroscopoInfo.Capricorn
import com.jorzus.horoscoapp.domain.model.HoroscopoInfo.Gemini
import com.jorzus.horoscoapp.domain.model.HoroscopoInfo.Leo
import com.jorzus.horoscoapp.domain.model.HoroscopoInfo.Libra
import com.jorzus.horoscoapp.domain.model.HoroscopoInfo.Pisces
import com.jorzus.horoscoapp.domain.model.HoroscopoInfo.Sagittarius
import com.jorzus.horoscoapp.domain.model.HoroscopoInfo.Scorpio
import com.jorzus.horoscoapp.domain.model.HoroscopoInfo.Taurus
import com.jorzus.horoscoapp.domain.model.HoroscopoInfo.Virgo
import javax.inject.Inject

class HoroscopoProvider @Inject constructor() {

    fun getHororoscopo(): List<HoroscopoInfo> {
        return listOf(
            Aries, Taurus, Gemini,
            Capricorn, Aquarius, Libra,
            Sagittarius, Scorpio, Cancer,
            Leo, Virgo, Pisces
        )
    }
}