package com.teamtwo.apilol.di.summoners

import android.app.Application
import androidx.room.Room
import com.example.data.RemoteSummonerDataSource
import com.teamtwo.apilol.BuildConfig
import com.teamtwo.apilol.model.LOLServiceManager
import com.teamtwo.apilol.model.database.ApiLolDatabase
import com.teamtwo.apilol.model.sumonners.SummonersRetrofitDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SummonersAppModule {

    @Provides @Singleton
    fun databaseProvider(app: Application) = Room.databaseBuilder(
        app,
        ApiLolDatabase::class.java,
        "api_lol_db"
    ).build()

    @Provides
    fun remoteDataSourceProvider(lolServiceManager: LOLServiceManager): RemoteSummonerDataSource
            = SummonersRetrofitDataSource(BuildConfig.API_KEY, lolServiceManager)

    val baseUrl = "https://ddragon.leagueoflegends.com/cdn/9.23.1/"
    val apiUrl = "https://euw1.api.riotgames.com/lol/"

    @Provides
    @Singleton
    fun lolServiceManagerProvider(): LOLServiceManager = LOLServiceManager(baseUrl, apiUrl)

}