package com.example.restaurantstan.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantstan.MVVM.ModelBegudes
import com.example.restaurantstan.MVVM.ModelPlats
import com.example.restaurantstan.R

class AdapterRest(var dataset: List<ModelPlats>) : RecyclerView.Adapter<AdapterRest.ViewHolder>() {

    private lateinit var mListener : onItemClickListener
    interface onItemClickListener {

        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

      val myDataPlats = mutableListOf<ModelPlats>()

    class ViewHolder(private val itemView: View,listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val nomPlatCard : TextView = itemView.findViewById(R.id.NomItem)
        var preuPlatCard : TextView = itemView.findViewById(R.id.PreuItem)

        init{
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.cardviewrest,parent,false)
        return ViewHolder((adapterLayout),mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var itemPlat = dataset[position]
        holder.nomPlatCard.text = itemPlat.nomPlat
        holder.preuPlatCard.text = itemPlat.preuPlat.toString()
    }

    fun getItemCountPlats(): Int {
        return dataset.size
    }

    fun submitList (newDataPlats:List<ModelPlats>){
        myDataPlats.clear()
        myDataPlats.addAll(newDataPlats)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return dataset.size
    }


}