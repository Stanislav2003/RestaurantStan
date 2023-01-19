package com.example.restaurantstan

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantstan.Adapter.AdapterBegudes
import com.example.restaurantstan.Adapter.AdapterPlatsROOM
import com.example.restaurantstan.Adapter.AdapterRest
import com.example.restaurantstan.MVVM.ModelPlats
import com.example.restaurantstan.Room.RecyclerClickListener
import com.example.restaurantstan.Room.RestaurantDatabase
import com.example.restaurantstan.databinding.FragmentDemanarPlatsBinding
import com.example.restaurantstan.viewmodel.MyViewModel
import com.example.restaurantstan.viewmodel.SharedViewModelRest
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FragmentDemanarPlats : Fragment() {
//    val applicationContext: Context
//        get() {
//            TODO()
//        }
    lateinit var recyclerViewPlat : RecyclerView
    lateinit var recyclerViewBeguda : RecyclerView
    private val meuViewModel: MyViewModel by viewModels()
    lateinit var binding: FragmentDemanarPlatsBinding
    val SharedViewPlat: SharedViewModelRest by activityViewModels()
    //////////////

    // prova ROOM/
    //private val platsDatabase by lazy { RestaurantDatabase.getDatabase(.applicationContext).restaurantDao() }
    private val platsDatabase by lazy { activity?.let { RestaurantDatabase.getDatabase(it.applicationContext).restaurantDao() } }
    private lateinit var adapterPlatsROOM: AdapterPlatsROOM


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentDemanarPlatsBinding>(
            inflater,
            R.layout.fragment_demanar_plats, container, false
        )
        setRecyclerView()
        observePlats()



//        adapterPlatsROOM.submitList(platsDatabase?.getPlats())



/////////////////////////////////////////////////
//        recyclerViewPlat = binding.recyclerPlat
//        recyclerViewPlat.layoutManager = LinearLayoutManager(activity)
//
//        recyclerViewBeguda = binding.recyclerBeguda
//        recyclerViewBeguda.layoutManager = LinearLayoutManager(activity)
//
//        val myAdapterPlats=AdapterRest(meuViewModel.getPlats())
//        val myAdapterBegudes = AdapterBegudes(meuViewModel.getBegudes())
//
//        binding.recyclerPlat.adapter = myAdapterPlats
//        binding.recyclerBeguda.adapter = myAdapterBegudes
//
//        var listPlatss = ArrayList<ModelPlats>()
//
//        myAdapterPlats.setOnItemClickListener(object: AdapterRest.onItemClickListener{
//            override fun onItemClick(position: Int) {
//
//                var NomPlatClick = myAdapterPlats.dataset[position]
//                //SharedViewPlat.assignPlat(NomPlatClick)
//                SharedViewPlat.assignPlats(NomPlatClick,listPlatss)
//                //prova///////////////////////////////////////////////////
//                SharedViewPlat.PlatsShare.observe(viewLifecycleOwner
//                ) {
//                    binding.quest.text = it.nomPlat
//                }
//                //////////////////////////////////////////////////////////
//                Toast.makeText(activity,NomPlatClick.nomPlat,Toast.LENGTH_SHORT).show()
//            }
//
//        })
//
//        binding.clica.setOnClickListener{
//                view : View ->
//                view.findNavController().navigate(
//                R.id.action_fragmentDemanarPlats_to_totalPlatsBegudes)
//        }


//        meuViewModel.quoteModelPlats.observe(viewLifecycleOwner , Observer{
//            myAdapterPlats.submitList(it)
//        })
//
//        meuViewModel.quoteModelBegudes.observe(viewLifecycleOwner,Observer{
//            myAdapterBegudes.submitListBegudes(it)
//        })

        return binding.root

    }

    fun setRecyclerView() {
        val platsRecyclerviewROOM = binding.recyclerPlat
        platsRecyclerviewROOM.layoutManager = LinearLayoutManager(activity)
        platsRecyclerviewROOM.setHasFixedSize(true)
        adapterPlatsROOM = AdapterPlatsROOM()
        adapterPlatsROOM.setItemListener(object : RecyclerClickListener {

            override fun onItemRemoveClick(position: Int) {
//                val notesList = adapterPlatsROOM.currentList.toMutableList()
//                val platText = notesList[position].platNom
//                val platPreuROOM = notesList[position].platPreu
                ///remove courotine.. x despres...
            }

            override fun onItemClick(position: Int) {
                TODO("Not yet implemented")
            }
            //per despres... //CouroutineScope(Dispatchers.IO).launch{noteDatabase.deleteNote(removeNote)

        })
        platsRecyclerviewROOM.adapter = adapterPlatsROOM
    }
    fun observePlats() {
        lifecycleScope.launch {
            platsDatabase?.getPlats()?.collect(){ platsList->
                if (platsList.isNotEmpty()){
                    adapterPlatsROOM.submitList(platsList)
                }
            }
        }
    }

}