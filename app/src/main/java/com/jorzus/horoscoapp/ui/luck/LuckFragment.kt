package com.jorzus.horoscoapp.ui.luck

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jorzus.horoscoapp.databinding.FragmentLuckBinding
import dagger.hilt.android.AndroidEntryPoint


//recibir cosas inyectadas
@AndroidEntryPoint
class LuckFragment : Fragment() {

    private var _binding: FragmentLuckBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentLuckBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}