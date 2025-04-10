package com.jorzus.horoscoapp.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.jorzus.horoscoapp.R
import com.jorzus.horoscoapp.databinding.ActivityDetailBinding
import com.jorzus.horoscoapp.domain.model.HoroscopoModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


//recibir cosas inyectadas
@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()


    private val args: DetailActivityArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        detailViewModel.getHoroscopo(args.type)

        initListener()
        initUI()

        Log.i("abc", args.type.toString())

    }

    private fun initListener() {
        binding.imgBack.setOnClickListener(){
            onBackPressed() //obsoleto
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun initUI() {
        initUiState()
    }

    private fun initUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                detailViewModel.StateValue.collect {
                    when (it) {
                        is DetailState.Error -> {
                            errorState()
                        }

                        DetailState.Loading -> {
                            loadingState()
                        }

                        is DetailState.Success -> {
                            successState(it)
                        }
                    }
                }
            }
        }
    }


    private fun loadingState() {
        binding.loading.isVisible = true
    }

    private fun errorState() {

    }

    private fun successState(state: DetailState.Success) {
        binding.loading.isVisible = false

        binding.txtDetail.text = state.prediction
        binding.titleDetail.text = state.name


        val image = when(state.horoscopoModel){
            HoroscopoModel.Aries -> R.drawable.detail_aries
            HoroscopoModel.Taurus -> R.drawable.detail_taurus
            HoroscopoModel.Gemini -> R.drawable.detail_gemini
            HoroscopoModel.Cancer -> R.drawable.detail_cancer
            HoroscopoModel.Leo -> R.drawable.detail_leo
            HoroscopoModel.Virgo -> R.drawable.detail_virgo
            HoroscopoModel.Libra ->  R.drawable.detail_libra
            HoroscopoModel.Scorpio -> R.drawable.detail_scorpio
            HoroscopoModel.Sagittarius -> R.drawable.detail_sagittarius
            HoroscopoModel.Capricorn -> R.drawable.detail_capricorn
            HoroscopoModel.Aquarius -> R.drawable.detail_aquarius
            HoroscopoModel.Pisces -> R.drawable.detail_pisces
        }

        binding.imgDetail.setImageResource(image)

    }
}