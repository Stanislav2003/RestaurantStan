package com.example.restaurantstan.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.restaurantstan.MVVM.ModelBegudes
import com.example.restaurantstan.MVVM.ModelPlats


//import kotlinx.coroutines.NonCancellable.message

class SharedViewModelRest : ViewModel() {

//    val BegudesShare = MutableLiveData<ModelBegudes>()
      val PlatsShare= MutableLiveData<ModelPlats>()
      val PlatsShare2 = MutableLiveData<MutableList<ModelPlats>>()

    // function to send message
    fun assignPlat(plats: ModelPlats) {
        PlatsShare.value = plats
    }

    fun retornaPlat(): ModelPlats? {
        return PlatsShare.value
    }
    fun assignPlats(plats2: ModelPlats,listPlats:ArrayList<ModelPlats>): ArrayList<ModelPlats> {
        listPlats.add(plats2)
        PlatsShare2.value = listPlats
        return listPlats
    }

}