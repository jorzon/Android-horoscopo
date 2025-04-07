package com.jorzus.horoscoapp.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.navArgs
import com.jorzus.horoscoapp.R
import com.jorzus.horoscoapp.databinding.ActivityDetailBinding
import com.jorzus.horoscoapp.ui.horosco.HoroscopoViewModel
import dagger.hilt.android.AndroidEntryPoint


//recibir cosas inyectadas
@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel:DetailViewModel by viewModels()


    private val args:DetailActivityArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i("abc" , args.type.toString())

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




    }
}