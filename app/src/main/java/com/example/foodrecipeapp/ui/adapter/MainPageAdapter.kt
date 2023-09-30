package com.example.foodrecipeapp.ui.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.navigation.navArgument
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodrecipeapp.MainActivity
import com.example.foodrecipeapp.R
import com.example.foodrecipeapp.data.entity.Details
import com.example.foodrecipeapp.data.entity.Recipe
import com.example.foodrecipeapp.ui.fragment.MainPageFragment
import com.example.foodrecipeapp.ui.fragment.MainPageFragmentDirections
import com.example.foodrecipeapp.ui.fragment.RecipeDetailFragment
import com.example.foodrecipeapp.ui.fragment.RecipeDetailFragmentArgs
import com.example.foodrecipeapp.ui.viewmodel.MainPageViewModel
import com.example.foodrecipeapp.utils.navigateFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainPageAdapter(var mContext: Context,
                      var foodList: List<Recipe>,
                      var viewModel: MainPageViewModel)
    : RecyclerView.Adapter<MainPageAdapter.CardViewHolder>(){

        inner class CardViewHolder(view : View) : RecyclerView.ViewHolder(view){
            var food_name: TextView
            var food_image: ImageView
            var cardView: CardView
            var fabMore: FloatingActionButton

            init {
                food_name = view.findViewById(R.id.food_name)
                food_image = view.findViewById(R.id.food_image)
                cardView = view.findViewById(R.id.cardView)
                fabMore = view.findViewById(R.id.fabMore)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = LayoutInflater.from(mContext).inflate(R.layout.main_fragment_card_design,parent,false)
        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {

        val food = foodList[position]
        holder.food_name.text = food.name

        val url = "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/ingredients-for-spring-vegetable-buddha-bowl-royalty-free-image-656873420-1558126238.jpg"
        Glide.with(mContext)
            .load(url)
            .into(holder.food_image)

        holder.fabMore.setOnClickListener {
            val move = MainPageFragmentDirections.actionMainPageFragmentToFoodDetailFragment(food.id)
            Navigation.navigateFragment(it, move)

        }

        holder.food_image.setOnClickListener {
            val move = MainPageFragmentDirections.actionMainPageFragmentToRecipeDetailFragment(food.id)
            Navigation.navigateFragment(it, move)

            }
        }
    }







