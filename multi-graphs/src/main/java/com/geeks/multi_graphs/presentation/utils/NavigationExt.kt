package com.geeks.multi_graphs.presentation.utils

import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.geeks.multi_graphs.R

fun Fragment.navController() = requireActivity().findNavController(R.id.nav_host_fragment)