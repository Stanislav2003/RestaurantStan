package com.example.restaurantstan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.restaurantstan.databinding.FragmentIniciBinding

class FragmentInici : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentIniciBinding>(
            inflater,
            R.layout.fragment_registre, container, false
        )
        return binding.root

    }


}