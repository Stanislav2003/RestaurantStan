package com.example.restaurantstan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.restaurantstan.databinding.ActivityHomeBinding

//import com.example.restaurantstan.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       //setContentView(R.layout.activity_home)
        val binding = DataBindingUtil.setContentView<ActivityHomeBinding>(this,
            R.layout.activity_home)
    }
}