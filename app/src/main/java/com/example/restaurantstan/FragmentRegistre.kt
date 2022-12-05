package com.example.restaurantstan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.restaurantstan.databinding.FragmentRegistreBinding
import kotlin.math.log


class FragmentRegistre : Fragment() {

    lateinit var binding : FragmentRegistreBinding


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = DataBindingUtil.inflate<FragmentRegistreBinding>(
            inflater,
            R.layout.fragment_registre, container, false
        )


        binding.Endavant.setOnClickListener{
            donarAlta()
        }

        return binding.root
    }


    fun donarAlta(){
        var NomUsuari = binding.NomUsuari.text.toString()
        var Contrasenya = binding.Contrasenya.text.toString()
        var RepContra = binding.RepetirCont.text.toString()
        var toast = Toast.makeText(activity, "les contrasenyes no son iguals!", Toast.LENGTH_LONG)

        if(Contrasenya == RepContra && Contrasenya != null && RepContra != null){
            binding.Endavant.setOnClickListener {
                    view : View ->
                    view.findNavController().navigate(
                    R.id.action_fragmentRegistre_to_fragmentDemanarPlats)
            }
        }
        else {
            toast.show()



        }
    }




    }



