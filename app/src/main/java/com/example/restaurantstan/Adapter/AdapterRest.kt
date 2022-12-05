package com.example.restaurantstan.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantstan.MVVM.ModelBegudes
import com.example.restaurantstan.MVVM.ModelPlats
import com.example.restaurantstan.MVVM.Provider
import com.example.restaurantstan.R

class AdapterRest(val dataset: List<ModelPlats>) : RecyclerView.Adapter<AdapterRest.ViewHolder>() {

    val myData = mutableListOf<ModelPlats>()

    class ViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomPlatCard : TextView = itemView.findViewById(R.id.NomPlat)
        var preuBegudaCard : TextView = itemView.findViewById(R.id.PreuPlat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.cardviewrest,parent,false)
        return ViewHolder((adapterLayout))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = dataset[position]
        holder.nomPlatCard.text = item.nomPlat
        holder.preuBegudaCard.text = item.preuPlat.toString()
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun submitList (newData:List<ModelPlats>){
        myData.clear()
        myData.addAll(newData)
        notifyDataSetChanged()
    }


}