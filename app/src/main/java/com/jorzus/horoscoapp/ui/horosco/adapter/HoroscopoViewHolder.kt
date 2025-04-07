package com.jorzus.horoscoapp.ui.horosco.adapter

import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.jorzus.horoscoapp.databinding.ItemHoroscopoBinding
import com.jorzus.horoscoapp.domain.model.HoroscopoInfo

class HoroscopoViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopoBinding.bind(view)

    fun render(item: HoroscopoInfo , onItemSelected:(HoroscopoInfo) -> Unit){
        Log.i("data" , item.name.toString())
        val context = binding.nameHoroscopo.context
        binding.nameHoroscopo.text = context.getString(item.name)
        binding.imgHoroscpo.setImageResource(item.image)


        binding.parent.setOnClickListener(){
            startRotation(binding.imgHoroscpo , newLambda = {onItemSelected(item)})
        }

    }


    private fun startRotation(view:View, newLambda:() -> Unit){
        //antes de iniciar aplica
        view.animate().apply {
            duration = 1000
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction{
                newLambda()
                start()
            }

        }
    }


}