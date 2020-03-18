package com.teamtwo.apilol.ui.summoners

import com.example.usecases.GetSpells
import com.example.usecases.GetSummoner
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module

class SummonerActivtyModule {

    @Provides
    fun summonerViewModel(getSumoner: GetSummoner) = SummonerViewModel(getSumoner)
}
    @Subcomponent(modules = [(SummonerActivtyModule::class)])
    interface SummonerActivtyComponent {
        val viewModel: SummonerViewModel
    }
