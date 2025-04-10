package com.jorzus.horoscoapp.ui.horosco

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jorzus.horoscoapp.databinding.FragmentHoroscopoBinding
import com.jorzus.horoscoapp.domain.model.HoroscopoInfo
import com.jorzus.horoscoapp.domain.model.HoroscopoModel
import com.jorzus.horoscoapp.ui.detail.DetailActivity
import com.jorzus.horoscoapp.ui.horosco.adapter.HoroscpoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


//recibir cosas inyectadas
@AndroidEntryPoint
class HoroscopoFragment : Fragment() {

    //cuando un activy carga un fragmet,
    //este crea la vista del fragmet


    // funcion delegada --> creamos el viewModel
    private val horoscopoViewModel by viewModels<HoroscopoViewModel>()


    private var _binding: FragmentHoroscopoBinding? = null
    private val binding get() = _binding!!


    lateinit var adapterH: HoroscpoAdapter


    //cuando la vista ya fue creada
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initUIState()
        initList()
    }

    private fun initList() {
        adapterH = HoroscpoAdapter() { item -> navigateToDetail(item)}
        binding.rvHoroscpo.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = adapterH
        }
    }

    private fun navigateToDetail(item:HoroscopoInfo) {

        val type = when(item){
            HoroscopoInfo.Aquarius -> HoroscopoModel.Aquarius
            HoroscopoInfo.Aries -> HoroscopoModel.Aries
            HoroscopoInfo.Cancer -> HoroscopoModel.Cancer
            HoroscopoInfo.Capricorn -> HoroscopoModel.Capricorn
            HoroscopoInfo.Gemini -> HoroscopoModel.Gemini
            HoroscopoInfo.Leo -> HoroscopoModel.Leo
            HoroscopoInfo.Libra -> HoroscopoModel.Libra
            HoroscopoInfo.Pisces -> HoroscopoModel.Pisces
            HoroscopoInfo.Sagittarius -> HoroscopoModel.Sagittarius
            HoroscopoInfo.Scorpio -> HoroscopoModel.Scorpio
            HoroscopoInfo.Taurus -> HoroscopoModel.Taurus
            HoroscopoInfo.Virgo -> HoroscopoModel.Virgo
        }


        findNavController().navigate(
            HoroscopoFragmentDirections.actionHoroscopoFragmentToDetailActivity(type)
        )
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                //al usar .collect ya estoy engsnchado
                horoscopoViewModel.horoscopo.collect {
                    Log.i("data", it.toString())
                    //CAMBIO EN HOROSCOPO
                    adapterH.updateList(it)
                }
            }
        }
    }

    //cuando se crea la vista
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHoroscopoBinding.inflate(layoutInflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }


}