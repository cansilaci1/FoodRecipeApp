package com.example.foodrecipeapp.data.entity


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Recipe(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
) : Serializable