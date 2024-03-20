package com.geeks.multi_graphs.presentation.ui.fragments.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geeks.multi_graphs.R
import com.geeks.multi_graphs.databinding.FragmentHomeBinding
import com.geeks.multi_graphs.presentation.utils.navController

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateToBasket()
        navigateToSettings()
    }

    private fun navigateToBasket() {
        binding.fabToBasket.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_basketFragment)
        }
    }

    private fun navigateToSettings() {
        binding.fabToSettings.setOnClickListener {
            navController().navigate(R.id.action_mainFlowFragment_to_settingsFlowFragment)
        }
    }
}