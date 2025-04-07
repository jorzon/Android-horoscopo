package com.jorzus.horoscoapp.ui.horosco

import androidx.lifecycle.ViewModel
import com.jorzus.horoscoapp.data.providers.HoroscopoProvider
import com.jorzus.horoscoapp.domain.model.HoroscopoInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class HoroscopoViewModel @Inject constructor(private val horoscopoProvider: HoroscopoProvider) :
    ViewModel() {


    //creamos un flow -->
    private var _horoscopo = MutableStateFlow<List<HoroscopoInfo>>(emptyList())

    //puede leerlos pero no modificarlos
    val horoscopo: StateFlow<List<HoroscopoInfo>> = _horoscopo


    //metodo de los viewmodel que se llama al crear el viewmodel, y los llenamos de datos
    init {
        _horoscopo.value = horoscopoProvider.getHororoscopo()

    }


}