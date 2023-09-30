package com.example.foodrecipeapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodrecipeapp.data.repo.FoodDaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddRecipeViewModel @Inject constructor(var frepo: FoodDaRepository): ViewModel() {
    val liveData: MutableLiveData<Boolean> = MutableLiveData()
    fun add(name: String, description: String){
        frepo.newRecipe(name, description, liveData)
    }
}