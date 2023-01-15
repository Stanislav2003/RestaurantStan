package com.example.restaurantstan.viewmodel

import android.graphics.ColorSpace
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.restaurantstan.MVVM.ModelBegudes
import com.example.restaurantstan.MVVM.ModelPlats
import com.example.restaurantstan.MVVM.Provider


   class MyViewModel : ViewModel() {

       val  quoteModelBegudes = MutableLiveData<List<ModelBegudes>>()
        val quoteModelPlats = MutableLiveData<List<ModelPlats>>()


//        fun randomPlatBeguda()  {
//            var Plat : List<ModelPlats> = Provider.Plats()
//            var Beguda : List<ModelBegudes> = Provider.Begudes()
//            quoteModelPlats.postValue(Plat)
//            quatoModelBegudes.postValue(Beguda)
//        }

       fun getPlats():List<ModelPlats>{
           return Provider.Plats()
       }

       fun getBegudes():List<ModelBegudes>{
           return Provider.Begudes()
       }



    }

