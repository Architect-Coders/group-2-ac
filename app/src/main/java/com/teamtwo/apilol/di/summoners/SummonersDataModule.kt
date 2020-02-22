package com.teamtwo.apilol.di.summoners

import com.example.data.*
import dagger.Module
import dagger.Provides

@Module
class SummonersDataModule {

    @Provides
    fun summonersRepositoryProvider(
        remoteDataSource: RemoteSummonerDataSource
    ) = SummonersRepository(remoteDataSource)
}