package com.teamtwo.apilol.di.summoners

import com.example.data.SummonerRemoteDataSource
import com.teamtwo.apilol.BuildConfig
import com.teamtwo.apilol.model.LOLServiceManager
import com.teamtwo.apilol.model.sumonners.SummonersRetrofitRemoteDataSource
import dagger.Module
import dagger.Provides

@Module
class SummonersAppModule {

    @Provides
    fun remoteDataSourceProvider(lolServiceManager: LOLServiceManager): SummonerRemoteDataSource
            = SummonersRetrofitRemoteDataSource(BuildConfig.API_KEY, lolServiceManager)
}