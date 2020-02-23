package com.teamtwo.apilol.di

import com.teamtwo.apilol.model.LOLServiceManager
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
open class ServerModule {

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