package com.example.restaurantstan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantstan.Adapter.AdapterBegudes
import com.example.restaurantstan.Adapter.AdapterRest
import com.example.restaurantstan.MVVM.ModelPlats
import com.example.restaurantstan.databinding.FragmentDemanarPlatsBinding
import com.example.restaurantstan.viewmodel.MyViewModel
import com.example.restaurantstan.viewmodel.SharedViewModelRest

class FragmentDemanarPlats : Fragment() {
    lateinit var recyclerViewPlat : RecyclerView
    lateinit var recyclerViewBeguda : RecyclerView
    private val meuViewModel: MyViewModel by viewModels()
    lateinit var binding: FragmentDemanarPlatsBinding
    val SharedViewPlat: SharedViewModelRest by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentDemanarPlatsBinding>(
            inflater,
            R.layout.fragment_demanar_plats, container, false
        )

        recyclerViewPlat = binding.recyclerPlat
        recyclerViewPlat.layoutManager = LinearLayoutManager(activity)

        recyclerViewBeguda = binding.recyclerBeguda
        recyclerViewBeguda.layoutManager = LinearLayoutManager(activity)

        val myAdapterPlats=AdapterRest(meuViewModel.getPlats())
        val myAdapterBegudes = AdapterBegudes(meuViewModel.getBegudes())

        binding.recyclerPlat.adapter = myAdapterPlats
        binding.recyclerBeguda.adapter = myAdapterBegudes

        var listPlatss = ArrayList<ModelPlats>()

        myAdapterPlats.setOnItemClickListener(object: AdapterRest.onItemClickListener{
            override fun onItemClick(position: Int) {

                var NomPlatClick = myAdapterPlats.dataset[position]
                //SharedViewPlat.assignPlat(NomPlatClick)
                SharedViewPlat.assignPlats(NomPlatClick,listPlatss)
                //prova///////////////////////////////////////////////////
                SharedViewPlat.PlatsShare.observe(viewLifecycleOwner
                ) {
                    binding.quest.text = it.nomPlat
                }
                //////////////////////////////////////////////////////////
                Toast.makeText(activity,NomPlatClick.nomPlat,Toast.LENGTH_SHORT).show()
            }

        })

        binding.clica.setOnClickListener{
                view : View ->
                view.findNavController().navigate(
                R.id.action_fragmentDemanarPlats_to_totalPlatsBegudes)
        }


        meuViewModel.quoteModelPlats.observe(viewLifecycleOwner , Observer{
            myAdapterPlats.submitList(it)
        })

        meuViewModel.quoteModelBegudes.observe(viewLifecycleOwner,Observer{
            myAdapterBegudes.submitListBegudes(it)
        })

        return binding.root

    }

}