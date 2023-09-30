package com.example.foodrecipeapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.lottie.LottieAnimationView
import com.example.foodrecipeapp.R
import com.example.foodrecipeapp.databinding.FragmentMainPageBinding
import com.example.foodrecipeapp.ui.adapter.MainPageAdapter
import com.example.foodrecipeapp.ui.viewmodel.MainPageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainPageFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentMainPageBinding
    private lateinit var viewModel: MainPageViewModel
    private lateinit var lottieAnimationView: LottieAnimationView
    private lateinit var imageView: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainPageBinding.inflate(inflater, container, false)

        binding.rvMainPage.layoutManager = LinearLayoutManager(requireContext())


        binding.floatingActionButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainPageFragment_to_addRecipeFragment)

        }

        binding.toolbar.title = "OI Food Recipes"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        viewModel.foodList.observe(viewLifecycleOwner) { foodList ->
            val adapter = foodList?.let { MainPageAdapter(requireContext(), it, viewModel) }

            binding.rvMainPage.adapter = adapter
        }
        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu)

                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as SearchView

                searchView.setOnQueryTextListener(this@MainPageFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)

      /*  val db = Firebase.firestore
        val collectionImages = db.collection("images")

        val image = FoodImage("img.png")

        collectionImages.document().set(image)*/

        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : MainPageViewModel by viewModels ()
        viewModel = tempViewModel
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            viewModel.search(query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null) {
            viewModel.search(newText)
        }
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadFood()
    }



}