package com.example.foodrecipeapp.ui.fragment

import android.os.Bundle
import android.transition.Fade
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.airbnb.lottie.LottieAnimationView
import com.example.foodrecipeapp.R
import com.example.foodrecipeapp.databinding.FragmentIntroBinding

class IntroFragment : Fragment() {
    private lateinit var binding: FragmentIntroBinding
    private lateinit var lottieAnimationView: LottieAnimationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIntroBinding.inflate(inflater, container, false)
        lottieAnimationView = binding.lottieAnimationView // lottie animation başladığı yer

        lottieAnimationView.playAnimation()

        binding.startTv.setOnClickListener {

            Navigation.findNavController(it).navigate(R.id.action_introFragment_to_mainPageFragment)
        }

        return binding.root
    }

    }

