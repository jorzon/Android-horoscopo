package com.jorzus.horoscoapp.ui.horosco.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jorzus.horoscoapp.R
import com.jorzus.horoscoapp.domain.model.HoroscopoInfo

class HoroscpoAdapter(private var listado: List<HoroscopoInfo> = emptyList() , private val onItemSelected:(HoroscopoInfo) -> Unit):
    RecyclerView.Adapter<HoroscopoViewHolder>() {



        fun updateList(list:List<HoroscopoInfo>){
            listado = list
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscopo, parent, false)
        return HoroscopoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listado.size
    }

    override fun onBindViewHolder(holder: HoroscopoViewHolder, position: Int) {
        holder.render(listado[position] , onItemSelected )
    }


}