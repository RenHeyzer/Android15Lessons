package com.geeks.multi_graphs.presentation.ui.fragments.payment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geeks.multi_graphs.R
import com.geeks.multi_graphs.databinding.FragmentPaymentFlowBinding

class PaymentFlowFragment : Fragment(R.layout.fragment_payment_flow) {

    private val binding by viewBinding(FragmentPaymentFlowBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.payment_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }
}