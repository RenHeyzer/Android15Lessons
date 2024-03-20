package com.geeks.multi_graphs.presentation.ui.fragments.registration

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geeks.multi_graphs.R
import com.geeks.multi_graphs.databinding.FragmentBasketBinding
import com.geeks.multi_graphs.databinding.FragmentMainFlowBinding
import com.geeks.multi_graphs.databinding.FragmentRegistrationFlowBinding

class RegistrationFlowFragment : Fragment(R.layout.fragment_registration_flow) {

    private val binding by viewBinding(FragmentRegistrationFlowBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.registration_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }
}