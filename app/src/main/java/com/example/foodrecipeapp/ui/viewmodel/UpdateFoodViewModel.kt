package com.example.foodrecipeapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodrecipeapp.data.repo.FoodDaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UpdateFoodViewModel  @Inject constructor(var frepo: FoodDaRepository): ViewModel(){

    val liveData: MutableLiveData<Boolean> = MutableLiveData()


    fun update(id: Int, name: String, description: String){
        frepo.updateFood(id, name, description, liveData)
    }
}