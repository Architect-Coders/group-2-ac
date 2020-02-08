package com.teamtwo.apilol.di.champions

import com.example.data.ChampionsRepository
import com.example.usecases.GetChampion
import com.example.usecases.GetChampions
import com.example.usecases.UpdateChampion
import dagger.Module
import dagger.Provides

@Module
class ChampionsUseCaseModule {

    @Provides
    fun getChampionProvider(championsRepository: ChampionsRepository)
            = GetChampion(championsRepository)

    @Provides
    fun getGetChampionsProvider(championsRepository: ChampionsRepository)
            = GetChampions(championsRepository)

    @Provides
    fun updateChampionProvider(championsRepository: ChampionsRepository)
            = UpdateChampion(championsRepository)

}