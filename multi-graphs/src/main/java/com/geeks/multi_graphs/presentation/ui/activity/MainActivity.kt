package com.geeks.multi_graphs.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.geeks.multi_graphs.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        val isRegistered = true
        if (isRegistered) {
            navGraph.setStartDestination(R.id.mainFlowFragment)
        } else {
            navGraph.setStartDestination(R.id.registrationFlowFragment)
        }
        navController.graph = navGraph
    }
}