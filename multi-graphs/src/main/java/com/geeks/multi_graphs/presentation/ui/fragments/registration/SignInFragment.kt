package com.geeks.multi_graphs.presentation.ui.fragments.registration

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geeks.multi_graphs.R
import com.geeks.multi_graphs.databinding.FragmentSignInBinding
import com.geeks.multi_graphs.presentation.utils.navController

class SignInFragment : Fragment(R.layout.fragment_sign_in) {

    private val binding by viewBinding(FragmentSignInBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvTitle.setOnClickListener {
            navController().navigate(R.id.action_registrationFlowFragment_to_mainFlowFragment)
        }
    }
}