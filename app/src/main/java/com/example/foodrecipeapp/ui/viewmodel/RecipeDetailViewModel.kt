package com.example.foodrecipeapp.ui.viewmodel

import DetailResponse
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodrecipeapp.data.repo.FoodDaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(var frepo: FoodDaRepository): ViewModel(){

    val recipeData: MutableLiveData<DetailResponse> = MutableLiveData()

    fun detail(id: Int){
       frepo.recipeDetail(id, recipeData)
    }

}