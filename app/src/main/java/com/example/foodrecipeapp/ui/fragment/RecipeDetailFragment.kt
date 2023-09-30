package com.example.foodrecipeapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.foodrecipeapp.data.entity.Update
import com.example.foodrecipeapp.databinding.FragmentRecipeDetailBinding
import com.example.foodrecipeapp.ui.viewmodel.RecipeDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeDetailFragment : Fragment() {
    private lateinit var binding: FragmentRecipeDetailBinding
    private lateinit var viewModel: RecipeDetailViewModel
    private lateinit var list: List<Update>

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)

            viewModel = ViewModelProvider(this).get(RecipeDetailViewModel::class.java)

            val bundle: RecipeDetailFragmentArgs by navArgs()
            val food_id = bundle.id

            viewModel.detail(food_id)

            viewModel.recipeData.observe(viewLifecycleOwner){ recipeData ->
                val url = "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/ingredients-for-spring-vegetable-buddha-bowl-royalty-free-image-656873420-1558126238.jpg"
                Glide.with(this)
                    .load(url)
                    .into(binding.imageViewFoodImageDetail)
                binding.textViewRecipeDetailText.text = recipeData.recipes.name
                binding.textViewRecipeDetailText2.text = recipeData.recipes.description
            }

            return binding.root
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: RecipeDetailViewModel by viewModels ()
        viewModel = tempViewModel
    }

    }
