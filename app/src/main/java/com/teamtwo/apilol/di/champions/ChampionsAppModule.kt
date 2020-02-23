package com.teamtwo.apilol.di.champions

import com.example.data.ChampionsLocalDataSource
import com.example.data.ChampionsRemoteDataSource
import com.teamtwo.apilol.model.LOLServiceManager
import com.teamtwo.apilol.model.champions.ChampionsRetrofitDataSource
import com.teamtwo.apilol.model.champions.ChampionsRoomDataSource
import com.teamtwo.apilol.model.database.ApiLolDatabase
import dagger.Module
import dagger.Provides

@Module
class ChampionsAppModule {

    @Provides
    fun localDataSourceProvider(db: ApiLolDatabase): ChampionsLocalDataSource = ChampionsRoomDataSource(db)

    @Provides
    fun remoteDataSourceProvider(lolServiceManager: LOLServiceManager): ChampionsRemoteDataSource
            = ChampionsRetrofitDataSource(lolServiceManager)
}