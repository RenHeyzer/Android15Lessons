package com.geeks.pokeapiandroid15.presentation.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geeks.pokeapiandroid15.R
import com.geeks.pokeapiandroid15.databinding.FragmentPokemonBinding
import com.geeks.pokeapiandroid15.presentation.ui.adapters.PokemonAdapter
import com.geeks.pokeapiandroid15.presentation.utils.snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PokemonFragment : Fragment(R.layout.fragment_pokemon) {

    private val binding by viewBinding(FragmentPokemonBinding::bind)
    private val viewModel by viewModels<PokemonViewModel>()
    private val pokemonAdapter = PokemonAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        handlePagingState()
        setupObserves()
    }

    private fun initialize() {
        binding.rvPokemon.apply {
            adapter = pokemonAdapter
        }
    }

    private fun handlePagingState() {
        pokemonAdapter.addLoadStateListener {
            when (val append = it.source.append) {
                is LoadState.Error -> {
                    append.error.message?.let { message -> snackbar(message) }
                }

                LoadState.Loading -> {}
                is LoadState.NotLoading -> {}
            }
        }
    }

    private fun setupObserves() {
        viewModel.pokemonLiveData.observe(viewLifecycleOwner) {
            viewLifecycleOwner.lifecycleScope.launch {
                pokemonAdapter.submitData(it)
            }
        }
    }
}