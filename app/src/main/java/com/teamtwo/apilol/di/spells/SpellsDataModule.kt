package com.teamtwo.apilol.di.spells

import com.example.data.SpellsLocalDataSource
import com.example.data.SpellsRemoteDataSource
import com.example.data.SpellsRepository
import dagger.Module
import dagger.Provides


@Module
class SpellsDataModule {

    @Provides
    fun spellRepositoryProvider(
        localDataSource: SpellsLocalDataSource,
        remoteDataSource: SpellsRemoteDataSource
    ) = SpellsRepository(localDataSource, remoteDataSource)
}