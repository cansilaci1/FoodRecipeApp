package com.example.foodrecipeapp.data.entity

import com.google.gson.annotations.SerializedName

data class StatusMessage(
    @SerializedName("status")
    val status: Int,
    @SerializedName("message")
    val message: String)
