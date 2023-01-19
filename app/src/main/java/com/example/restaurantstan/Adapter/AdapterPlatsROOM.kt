package com.example.restaurantstan.Adapter

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.leanback.widget.DiffCallback
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantstan.Room.PlatsEntity
import com.example.restaurantstan.Room.RecyclerClickListener
import androidx.recyclerview.widget.ListAdapter
import com.example.restaurantstan.R


class AdapterPlatsROOM : ListAdapter<PlatsEntity, AdapterPlatsROOM.PlatsROOMHolder>(DiffCallback()) {

    class PlatsROOMHolder(view: View) : RecyclerView.ViewHolder(view)

    private lateinit var listener: RecyclerClickListener
    fun setItemListener(listener: RecyclerClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlatsROOMHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.cardviewrest, parent, false)
        val platsHolder = PlatsROOMHolder(v)

//        val noteDelete = platsHolder.itemView.findViewById<ImageView>(R.id.note_delete)
//        noteDelete.setOnClickListener {
//            listener.onItemRemoveClick(platsHolder.adapterPosition)
//        }

//        val nomPlat = platsHolder.itemView.findViewById<CardView>(R.id.NomItem)
//        nomPlat.setOnClickListener {
//            listener.onItemClick(platsHolder.adapterPosition)
//        }

        return platsHolder
    }

    override fun onBindViewHolder(holder: PlatsROOMHolder, position: Int) {
        val currentItem = getItem(position)
        val platText = holder.itemView.findViewById<TextView>(R.id.NomItem)
        platText.text = currentItem.platNom
        val platPreu = holder.itemView.findViewById<TextView>(R.id.PreuItem)
        platPreu.text = currentItem.platPreu.toString()+"  euros"
    }

    class DiffCallback : DiffUtil.ItemCallback<PlatsEntity>() {
        override fun areItemsTheSame(oldItem:PlatsEntity, newItem: PlatsEntity) =
            oldItem.platNom == newItem.platNom

        override fun areContentsTheSame(oldItem: PlatsEntity, newItem: PlatsEntity) =
            oldItem == newItem
        }
    }
