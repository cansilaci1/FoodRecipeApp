package com.example.foodrecipeapp.retrofit

import retrofit2.Retrofit

//https://api.canerture.com/recipes/

class APIUtils {
    companion object{
        val BASE_URL = "https://api.canerture.com/recipes/"

        fun getFoodDao(): FoodDao{
            return RetrofitClient.getClient(BASE_URL).create(FoodDao::class.java)
        }
    }
}