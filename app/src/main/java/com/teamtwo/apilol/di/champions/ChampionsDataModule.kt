package com.teamtwo.apilol.di.champions

import com.example.data.ChampionsLocalDataSource
import com.example.data.ChampionsRemoteDataSource
import com.example.data.ChampionsRepository
import dagger.Module
import dagger.Provides

@Module
class ChampionsDataModule {

    @Provides
    fun championsRepositoryProvider(
        localDataSource: ChampionsLocalDataSource,
        remoteDataSource: ChampionsRemoteDataSource
    ) = ChampionsRepository(localDataSource, remoteDataSource)

}