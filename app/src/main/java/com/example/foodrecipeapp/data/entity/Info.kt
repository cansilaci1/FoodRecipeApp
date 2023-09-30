package com.example.foodrecipeapp.data.entity

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String
)
