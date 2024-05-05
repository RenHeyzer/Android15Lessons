package com.geeks.compose.domain.usecases

import com.geeks.compose.domain.repositories.CharactersRepository
import com.geeks.compose.utils.Either
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FetchFilterCharactersUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {

    operator fun invoke() = charactersRepository.fetchCharacters().map {
        if (it is Either.Right && it.right != null) {
            Either.Right(it.right.sortedByDescending { character ->
                character.name
            })
        } else {
            it as Either.Left
        }
    }
}