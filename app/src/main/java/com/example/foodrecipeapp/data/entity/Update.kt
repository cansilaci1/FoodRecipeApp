package com.example.foodrecipeapp.data.entity

import android.database.Observable
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.Observer

data class Update(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String
) :Serializable
