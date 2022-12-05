package com.example.restaurantstan

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import com.example.restaurantstan.databinding.FragmentMenuBinding
import androidx.navigation.findNavController

class FragmentMenu : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMenuBinding>(
            inflater,
            R.layout.fragment_menu, container, false
        )
        var registreButton: Button = binding.buttonRegistre
        var iniciaButton: Button = binding.buttonInicia


                registreButton.setOnClickListener{
                        view : View ->
                    view.findNavController().navigate(
                        R.id.action_fragmentMenu_to_fragmentRegistre
                    )
                }

                iniciaButton.setOnClickListener{
                        view : View ->
                    view.findNavController().navigate(
                        R.id.action_fragmentMenu_to_fragmentInici
                    )
                }

        return binding.root
        }
}
