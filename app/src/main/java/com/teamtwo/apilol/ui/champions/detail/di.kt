package com.teamtwo.apilol.ui.champions.detail

import com.example.usecases.GetChampion
import com.example.usecases.UpdateChampion
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class ChampionDetailActivityModule(private val championId: String) {

    @Provides
    fun championDetailViewModelProvider(
        getChampion: GetChampion,
        updateChampion: UpdateChampion
    ) = ChampionDetailViewModel(
        championId,
        getChampion,
        updateChampion
    )

}

@Subcomponent(modules = [(ChampionDetailActivityModule::class)])
interface ChampionDetailActivityComponent {
    val championDetailViewModel: ChampionDetailViewModel
}

