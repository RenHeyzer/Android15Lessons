package com.geeks.compose.ui.screens.characters

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.geeks.compose.R
import com.geeks.compose.data.remote.dtos.Character
import com.geeks.compose.ui.theme.PokeApiAndroid15Theme
import com.geeks.compose.ui.viewmodels.CharactersViewModel


@Composable
fun CharactersScreen(
    modifier: Modifier = Modifier,
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val gridState = rememberLazyGridState()
    val characters by viewModel.characters.observeAsState()

    LazyVerticalGrid(
        modifier = modifier,
        state = gridState,
        columns = GridCells.Fixed(2),
    ) {
        characters?.let {
            items(it) { character ->
                CharacterItem(character = character)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCharactersScreen() {
    PokeApiAndroid15Theme {
        CharactersScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun CharacterItem(
    modifier: Modifier = Modifier,
    character: Character
) = with(character) {
    Box(
        modifier = modifier.border(
            width = 0.dp,
            color = Color.Transparent,
            shape = RoundedCornerShape(10.dp)
        ),
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data(img)
                .crossfade(true)
                .placeholder(R.drawable.character_placeholder)
                .build(),
            contentDescription = stringResource(
                R.string.character_image_content_description,
                name
            ),
            contentScale = ContentScale.FillBounds,
        )

        Text(
            modifier = Modifier.align(Alignment.BottomCenter),
            text = name,
            color = Color.White,
            fontSize = 14.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCharacterItem() {
    PokeApiAndroid15Theme {
        CharacterItem(
            modifier = Modifier.wrapContentSize(),
            character = Character(
                id = 1,
                name = "Armin Arlelt",
                img = "https://static.wikia.nocookie.net/shingekinokyojin/images/9/93/Armin_Arlelt_%28Anime%29_character_image.png/revision/latest/scale-to-width-down/350?cb=20210322005647"
            )
        )
    }
}