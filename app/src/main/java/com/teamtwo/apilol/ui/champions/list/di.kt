package com.teamtwo.apilol.ui.champions.list

import com.example.usecases.GetChampions
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class ChampionListActivityModule {

    @Provides
    fun championListViewModelProvider(getChampions: GetChampions)
            = ChampionListViewModel(getChampions)
    
}

@Subcomponent(modules = [(ChampionListActivityModule::class)])
interface ChampionListActivityComponent {
    val viewModel: ChampionListViewModel
}