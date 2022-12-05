package com.example.restaurantstan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantstan.Adapter.AdapterRest
import com.example.restaurantstan.databinding.FragmentDemanarPlatsBinding
import com.example.restaurantstan.viewmodel.MyViewModel

class FragmentDemanarPlats : Fragment() {
    lateinit var recyclerView : RecyclerView
    private val meuViewModel: MyViewModel by viewModels()
    lateinit var binding: FragmentDemanarPlatsBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentDemanarPlatsBinding>(
            inflater,
            R.layout.fragment_demanar_plats, container, false
        )



        recyclerView = binding.recyclerPlat
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val myAdapter=AdapterRest(meuViewModel.getPlats())
        binding.recyclerPlat.adapter = myAdapter

        meuViewModel.quoteModelPlats.observe(viewLifecycleOwner , Observer{
            myAdapter.submitList(it)
        })



        binding.clica.setOnClickListener {
            meuViewModel.randomPlatBeguda() }


        return binding.root

    }


}