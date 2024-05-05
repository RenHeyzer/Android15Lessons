package com.geeks.compose.domain.repositories

import com.geeks.compose.domain.entities.Character
import com.geeks.compose.utils.Either
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    fun fetchCharacters(): Flow<Either<Throwable, List<Character>>>
}