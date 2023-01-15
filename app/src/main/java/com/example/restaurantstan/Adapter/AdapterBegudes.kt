package com.example.restaurantstan.Adapter

import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantstan.MVVM.ModelBegudes
import com.example.restaurantstan.MVVM.ModelPlats
import com.example.restaurantstan.R

class AdapterBegudes(var dataset2: List<ModelBegudes>) : RecyclerView.Adapter<AdapterBegudes.ViewHolder>() {

    val myDataBegudes = mutableListOf<ModelBegudes>()

    class ViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nomBegudaCard : TextView = itemView.findViewById(R.id.NomItem)
        var preuBegudaCard : TextView = itemView.findViewById(R.id.PreuItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.cardviewrest, parent, false)
        return ViewHolder((adapterLayout))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var itemBeguda = dataset2[position]
        holder.nomBegudaCard.text = itemBeguda.nomBeguda
        holder.preuBegudaCard.text = itemBeguda.preuBeguda.toString()
    }

     fun getItemCountBegudes(): Int {
        return dataset2.size
    }


    fun submitListBegudes (newDataBegudes:List<ModelBegudes>){
        myDataBegudes.clear()
        myDataBegudes.addAll(newDataBegudes)
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return dataset2.size
    }
}

