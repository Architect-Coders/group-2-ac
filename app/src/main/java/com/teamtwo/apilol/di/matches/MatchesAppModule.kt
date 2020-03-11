package com.teamtwo.apilol.di.matches

import com.example.data.MatchesLocalDataSource
import com.example.data.MatchesRemoteDataSource
import com.teamtwo.apilol.BuildConfig
import com.teamtwo.apilol.model.LOLServiceManager
import com.teamtwo.apilol.model.database.ApiLolDatabase
import com.teamtwo.apilol.model.matches.MatchesRetrofitDataSource
import com.teamtwo.apilol.model.matches.MatchesRoomDataSource
import dagger.Module
import dagger.Provides

@Module
class MatchesAppModule {

    @Provides
    fun localDataSourceProvider(db: ApiLolDatabase): MatchesLocalDataSource = MatchesRoomDataSource(db)

    @Provides
    fun remoteDataSourceProvider(lolServiceManager: LOLServiceManager): MatchesRemoteDataSource
            = MatchesRetrofitDataSource(BuildConfig.API_KEY, lolServiceManager)
}