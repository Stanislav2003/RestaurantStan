package com.example.restaurantstan

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.restaurantstan.MVVM.ModelPlats
import com.example.restaurantstan.databinding.FragmentTotalPlatsBegudesBinding
import com.example.restaurantstan.viewmodel.SharedViewModelRest
import java.util.Observer


class TotalPlatsBegudes : Fragment() {

    lateinit var binding : FragmentTotalPlatsBegudesBinding
    lateinit var frag : FragmentDemanarPlats
//    val SharedViewPlat : SharedViewModelRest by viewModels()
     val SharedViewPlat: SharedViewModelRest by activityViewModels()

    //lateinit var SharedViewPlat : SharedViewModelRest

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentTotalPlatsBegudesBinding>(
            inflater,
            R.layout.fragment_total_plats_begudes, container, false
        )

//        SharedViewPlat = ViewModelProvider(frag).get(SharedViewModelRest::class.java)

//        SharedViewPlat.PlatsShare.observe(viewLifecycleOwner , Observer{
//            binding.platTotal.text  = it.toString()
//
//
//
//        })
        var llistaPlatsTotal = binding.llistaPlatsTotal


        SharedViewPlat.PlatsShare2.observe(viewLifecycleOwner
        ) { platets ->
           llistaPlatsTotal.adapter = ArrayAdapter<String>(requireActivity(), android.R.layout.simple_list_item_1,platets)
            for(i in 0..platets.size-1)
            binding.llistaPlatsTotal.getItemAtPosition((i))
        }
//        SharedViewPlat.PlatsShare.observe(viewLifecycleOwner
//        ) { platets ->
//            binding.platTotal.setText(platets.nomPlat+"preu"+platets.preuPlat)
//        }

        return binding.root
    }

    }


