package com.example.foodrecipeapp.data.repo

import DetailResponse
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.foodrecipeapp.data.entity.Details
import com.example.foodrecipeapp.data.entity.Info
import com.example.foodrecipeapp.data.entity.Recipe
import com.example.foodrecipeapp.data.entity.Update
import com.example.foodrecipeapp.retrofit.FoodDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FoodDaRepository(var fdao: FoodDao) {

//repoda olmaması gerekiyor
    var foodList: MutableLiveData<List<Recipe>?>

    init {
        foodList = MutableLiveData()
    }

    fun getFood(): MutableLiveData<List<Recipe>?> {
        return foodList
    }

    fun getAllFood() {
        fdao.allFoods().enqueue(object : Callback<Details> {
            override fun onResponse(call: Call<Details>?, response: Response<Details>) {
                val liste = response.body()!!.recipes
                foodList.value = liste

            }

            override fun onFailure(call: Call<Details>?, t: Throwable?) {
            }

        })
    }

    fun newRecipe(name: String, description: String, liveData: MutableLiveData<Boolean>) {
        val info = Info(name, description)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = fdao.addRecipe(info).execute()

                if (response.isSuccessful) {

                    liveData.postValue(true)
                    getAllFood()

                } else {
                    liveData.postValue(false)
                }
            } catch (e: Exception) {
                liveData.postValue(false)
            }
        }
    }

    var recipeList: MutableLiveData<List<Update>?>
    init {
        recipeList = MutableLiveData()
    }

    fun recipeDetail(id: Int, recipeData: MutableLiveData<DetailResponse>){
        fdao.getRecipeDetail(id).enqueue(object : Callback<DetailResponse>{
            override fun onResponse(
                call: Call<DetailResponse>,
                response: Response<DetailResponse>
            ) {
                val status = response.body()!!.status
                val message = response.body()!!.message
                // dataları canlı olarak takip etme.
                recipeData.postValue(response.body())
                Log.e("food","$status - $message ")
            }

            override fun onFailure(call: Call<DetailResponse>, t: Throwable) {
                Log.e("food","error")
            }

        })
    }

    fun updateFood(id: Int, name: String, description: String, liveData: MutableLiveData<Boolean>){
        val update = Update(id,name, description)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = fdao.updateRecipe(update).execute()

                if (response.isSuccessful){

                    val status = response.body()?.status
                    val message = response.body()?.message
                    liveData.postValue(true)
                    Log.e("update", "$status - $message")

                } else {
                    liveData.postValue(false)
            }

        } catch (e: Exception){
            liveData.postValue(false)
        }
        }
    }

    fun searchFood(query: String){
        fdao.searchRecipe(query).enqueue(object : Callback<Details>{
            override fun onResponse(call: Call<Details>, response: Response<Details>) {
                val list = response.body()!!.recipes
                foodList.value = list
            }

            override fun onFailure(call: Call<Details>, t: Throwable) {

            }

        })
    }

}