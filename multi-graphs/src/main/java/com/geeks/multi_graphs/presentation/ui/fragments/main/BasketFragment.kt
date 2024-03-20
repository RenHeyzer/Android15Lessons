package com.geeks.multi_graphs.presentation.ui.fragments.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geeks.multi_graphs.R
import com.geeks.multi_graphs.databinding.FragmentBasketBinding
import com.geeks.multi_graphs.presentation.utils.navController

class BasketFragment : Fragment(R.layout.fragment_basket) {

    private val binding by viewBinding(FragmentBasketBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateToPayment()
    }

    private fun navigateToPayment() {
        binding.fabToPayment.setOnClickListener {
            navController().navigate(R.id.action_mainFlowFragment_to_paymentFlowFragment)
        }
    }
}