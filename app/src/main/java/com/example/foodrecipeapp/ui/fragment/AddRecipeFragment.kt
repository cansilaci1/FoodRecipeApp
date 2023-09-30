package com.example.foodrecipeapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.foodrecipeapp.R
import com.example.foodrecipeapp.databinding.FragmentAddRecipeBinding
import com.example.foodrecipeapp.ui.viewmodel.AddRecipeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddRecipeFragment : Fragment() {
private lateinit var binding: FragmentAddRecipeBinding
private lateinit var viewModel: AddRecipeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAddRecipeBinding.inflate(inflater, container, false)

        binding.buttonAddRecipe.setOnClickListener {
            val name = binding.editTextFoodName.text.toString()
            val description = binding.editTextFoodDetail.text.toString()
            buttonAdd(name, description)
        }

        viewModel.liveData.observe(viewLifecycleOwner){ isSuccess ->
            if (isSuccess){
                findNavController().navigateUp()
            }

        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AddRecipeViewModel by viewModels ()
        viewModel = tempViewModel
    }
    fun buttonAdd(name: String, description: String){
        viewModel.add(name, description)
    }

}