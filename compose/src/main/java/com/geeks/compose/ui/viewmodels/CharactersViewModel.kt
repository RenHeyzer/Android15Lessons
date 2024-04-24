package com.geeks.compose.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geeks.compose.data.remote.dtos.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor() : ViewModel() {

    private val _characters = MutableLiveData<List<Character>>(
        listOf(
            Character(
                id = 1,
                name = "Armin Arlelt",
                img = "https://klev.club/uploads/posts/2023-10/1697814685_klev-club-p-arti-anime-ataka-titanov-armin-4.jpg"
            ),Character(
                id = 2,
                name = "Mikasa Ackermann",
                img = "https://citaty.info/files/characters/142539.png"
            ),Character(
                id = 1,
                name = "Armin Arlelt",
                img = "https://klev.club/uploads/posts/2023-10/1697814685_klev-club-p-arti-anime-ataka-titanov-armin-4.jpg"
            ),Character(
                id = 1,
                name = "Armin Arlelt",
                img = "https://klev.club/uploads/posts/2023-10/1697814685_klev-club-p-arti-anime-ataka-titanov-armin-4.jpg"
            ),Character(
                id = 1,
                name = "Armin Arlelt",
                img = "https://klev.club/uploads/posts/2023-10/1697814685_klev-club-p-arti-anime-ataka-titanov-armin-4.jpg"
            ),Character(
                id = 1,
                name = "Armin Arlelt",
                img = "https://klev.club/uploads/posts/2023-10/1697814685_klev-club-p-arti-anime-ataka-titanov-armin-4.jpg"
            ),Character(
                id = 1,
                name = "Armin Arlelt",
                img = "https://klev.club/uploads/posts/2023-10/1697814685_klev-club-p-arti-anime-ataka-titanov-armin-4.jpg"
            ),Character(
                id = 1,
                name = "Armin Arlelt",
                img = "https://klev.club/uploads/posts/2023-10/1697814685_klev-club-p-arti-anime-ataka-titanov-armin-4.jpg"
            ),Character(
                id = 1,
                name = "Armin Arlelt",
                img = "https://klev.club/uploads/posts/2023-10/1697814685_klev-club-p-arti-anime-ataka-titanov-armin-4.jpg"
            ),Character(
                id = 1,
                name = "Armin Arlelt",
                img = "https://klev.club/uploads/posts/2023-10/1697814685_klev-club-p-arti-anime-ataka-titanov-armin-4.jpg"
            ),Character(
                id = 1,
                name = "Armin Arlelt",
                img = "https://klev.club/uploads/posts/2023-10/1697814685_klev-club-p-arti-anime-ataka-titanov-armin-4.jpg"
            ),Character(
                id = 1,
                name = "Armin Arlelt",
                img = "https://klev.club/uploads/posts/2023-10/1697814685_klev-club-p-arti-anime-ataka-titanov-armin-4.jpg"
            ),Character(
                id = 1,
                name = "Armin Arlelt",
                img = "https://klev.club/uploads/posts/2023-10/1697814685_klev-club-p-arti-anime-ataka-titanov-armin-4.jpg"
            ),Character(
                id = 1,
                name = "Armin Arlelt",
                img = "https://klev.club/uploads/posts/2023-10/1697814685_klev-club-p-arti-anime-ataka-titanov-armin-4.jpg"
            ),Character(
                id = 1,
                name = "Armin Arlelt",
                img = "https://klev.club/uploads/posts/2023-10/1697814685_klev-club-p-arti-anime-ataka-titanov-armin-4.jpg"
            ),Character(
                id = 1,
                name = "Armin Arlelt",
                img = "https://klev.club/uploads/posts/2023-10/1697814685_klev-club-p-arti-anime-ataka-titanov-armin-4.jpg"
            ),Character(
                id = 1,
                name = "Armin Arlelt",
                img = "https://klev.club/uploads/posts/2023-10/1697814685_klev-club-p-arti-anime-ataka-titanov-armin-4.jpg"
            ),Character(
                id = 1,
                name = "Armin Arlelt",
                img = "https://klev.club/uploads/posts/2023-10/1697814685_klev-club-p-arti-anime-ataka-titanov-armin-4.jpg"
            ),Character(
                id = 1,
                name = "Armin Arlelt",
                img = "https://klev.club/uploads/posts/2023-10/1697814685_klev-club-p-arti-anime-ataka-titanov-armin-4.jpg"
            ),
        )
    )
    val characters: LiveData<List<Character>> = _characters
}