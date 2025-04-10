package com.jorzus.horoscoapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorzus.horoscoapp.domain.model.HoroscopoModel
import com.jorzus.horoscoapp.domain.useCase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase) :
    ViewModel() {

    private var _state = MutableStateFlow<DetailState>(DetailState.Loading)
    val StateValue: StateFlow<DetailState> = _state

    lateinit var horoscopo: HoroscopoModel

    fun getHoroscopo(sign:HoroscopoModel) {
        horoscopo = sign
        viewModelScope.launch {
            _state.value = DetailState.Loading
            var result = withContext(Dispatchers.IO){getPredictionUseCase(sign.name)} // HILO SECUNDARIO
            if(result != null){
                _state.value = DetailState.Success(result.horoscope , result.sign , horoscopo)
            } else {
                _state.value = DetailState.Error("error intentalo mas tarde")
            }
        }

    }


}