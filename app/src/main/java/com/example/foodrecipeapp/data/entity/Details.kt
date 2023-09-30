package com.example.foodrecipeapp.data.entity


import com.google.gson.annotations.SerializedName

data class Details(
    @SerializedName("message")
    val message: String,
    @SerializedName("recipes")
    val recipes: List<Recipe>,
    @SerializedName("status")
    val status: Int
)