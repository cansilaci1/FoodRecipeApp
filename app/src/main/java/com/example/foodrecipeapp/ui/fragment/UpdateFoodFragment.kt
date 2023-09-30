package com.example.foodrecipeapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.foodrecipeapp.data.entity.Update
import com.example.foodrecipeapp.databinding.FragmentUpdateFoodBinding
import com.example.foodrecipeapp.ui.viewmodel.RecipeDetailViewModel
import com.example.foodrecipeapp.ui.viewmodel.UpdateFoodViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateFoodFragment : Fragment() {
    private lateinit var binding: FragmentUpdateFoodBinding
    private lateinit var viewModel: UpdateFoodViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateFoodBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(UpdateFoodViewModel::class.java)

        //async bi şekilde fragment açıkken devam edecek
        viewModel.liveData.observe(viewLifecycleOwner){ isSuccess ->
            if (isSuccess){
                findNavController().navigateUp()
            }

        }

        val bundle: UpdateFoodFragmentArgs by navArgs ()
        val foodId = bundle.id

        binding.buttonUpdate.setOnClickListener {
            updateRecipe(foodId, binding.editTextFoodName2.text.toString(), binding.editTextFoodDetail2.text.toString())
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: UpdateFoodViewModel by viewModels()
        viewModel = tempViewModel
    }

    private fun updateRecipe(id: Int,name: String, description: String) {
        viewModel.update(id, name, description)
    }
}
