package com.teamtwo.apilol.di

import android.app.Application
import androidx.room.Room
import com.teamtwo.apilol.model.LOLServiceManager
import com.teamtwo.apilol.model.database.ApiLolDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
open class DataSourcesModule {

    @Provides @Singleton
    fun databaseProvider(app: Application) = Room.databaseBuilder(
        app,
        ApiLolDatabase::class.java,
        "api_lol_db"
    ).build()

    @Provides
    @Singleton
    @Named("baseUrl")
    fun baseUrlProvider(): String = "https://ddragon.leagueoflegends.com/cdn/9.23.1/"

    @Provides
    @Singleton
    @Named("apiUrl")
    fun apiUrlProvider(): String = "https://euw1.api.riotgames.com/lol/"

    @Provides
    @Singleton
    fun lolServiceManagerProvider(@Named("baseUrl") baseUrl: String,
                                  @Named("apiUrl") apiUrl: String): LOLServiceManager
            = LOLServiceManager(baseUrl, apiUrl)
}