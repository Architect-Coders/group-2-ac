package com.teamtwo.apilol.di.matches

import com.example.data.MatchesLocalDataSource
import com.example.data.MatchesRemoteDataSource
import com.example.data.MatchesRepository
import dagger.Module
import dagger.Provides

@Module
class MatchesDataModule {

    @Provides
    fun matchesRepositoryProvider(
        localDataSource: MatchesLocalDataSource,
        remoteDataSource: MatchesRemoteDataSource
    ) = MatchesRepository(localDataSource, remoteDataSource)
}