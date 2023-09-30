package com.example.foodrecipeapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodrecipeapp.data.entity.Recipe
import com.example.foodrecipeapp.data.repo.FoodDaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(var frepo: FoodDaRepository):  ViewModel() {
    var foodList = MutableLiveData<List<Recipe>?>()

    init {
        loadFood()
        foodList = frepo.getFood()
    }

    fun loadFood(){
        frepo.getAllFood()
    }
  /*  fun updateFoodList(newFoodList: List<Recipe>) {
        foodList.value = newFoodList
    }*/
    fun search(query: String){
        frepo.searchFood(query)
    }
}