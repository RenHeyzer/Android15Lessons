package com.geeks.compose.presentation.ui.screens.characters

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.geeks.compose.presentation.ui.screens.characters.components.CharactersList
import com.geeks.compose.presentation.ui.viewmodels.CharactersViewModel
import com.geeks.compose.utils.UIState


@Composable
fun CharactersScreen(
    modifier: Modifier = Modifier,
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val gridState = rememberLazyGridState()
    val characters by viewModel.charactersState.observeAsState()

    characters?.let { uiState ->
        when (uiState) {
            is UIState.Error -> {}
            UIState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = Color.Black)
                }
            }

            is UIState.Success -> {
                CharactersList(
                    modifier = Modifier.fillMaxSize(),
                    gridState = gridState,
                    characters = uiState.data
                )
            }
        }
    }
}