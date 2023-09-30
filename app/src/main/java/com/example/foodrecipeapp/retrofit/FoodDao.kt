package com.example.foodrecipeapp.retrofit

import DetailResponse
import com.example.foodrecipeapp.data.entity.Details
import com.example.foodrecipeapp.data.entity.Info
import com.example.foodrecipeapp.data.entity.StatusMessage
import com.example.foodrecipeapp.data.entity.Update
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface FoodDao {

    @GET("get_recipes.php")
    fun allFoods(): Call<Details>

    //https://api.canerture.com/recipes/add_recipe.php
    @POST("add_recipe.php")
    fun addRecipe(
        @Body info: Info
    ): Call<StatusMessage>

    //https://api.canerture.com/recipes/update_recipe.php
    @POST("update_recipe.php")
    fun updateRecipe(
        @Body update: Update
    ): Call <StatusMessage>

    //search_recipe.php
    @GET("search_recipe.php")
    fun searchRecipe(
        @Query("query") query: String
    ): Call<Details>

    //get_recipe_detail.php
    @GET("get_recipe_detail.php")
    fun getRecipeDetail(
        @Query("id") id: Int
    ): Call <DetailResponse>
}