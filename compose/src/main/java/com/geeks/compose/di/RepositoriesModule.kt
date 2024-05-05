package com.geeks.compose.di

import com.geeks.compose.data.repositories.CharactersRepositoryImpl
import com.geeks.compose.domain.repositories.CharactersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoriesModule {

    @Binds
    @ViewModelScoped
    fun bindCharacterRepository(repositoryImpl: CharactersRepositoryImpl): CharactersRepository
}