package com.example.foodrecipeapp.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.navigateFragment(it: View, id: NavDirections){
    findNavController(it).navigate(id)
}