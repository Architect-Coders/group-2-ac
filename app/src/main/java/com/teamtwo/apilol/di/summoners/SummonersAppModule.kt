package com.teamtwo.apilol.di.summoners

import com.example.data.RemoteSummonerDataSource
import com.teamtwo.apilol.BuildConfig
import com.teamtwo.apilol.model.LOLServiceManager
import com.teamtwo.apilol.model.sumonners.SummonersRetrofitDataSource
import dagger.Module
import dagger.Provides

@Module
class SummonersAppModule {

    @Provides
    fun remoteDataSourceProvider(lolServiceManager: LOLServiceManager): RemoteSummonerDataSource
            = SummonersRetrofitDataSource(BuildConfig.API_KEY, lolServiceManager)
}