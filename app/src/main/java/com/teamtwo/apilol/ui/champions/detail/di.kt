package com.teamtwo.apilol.ui.champions.detail

import com.example.usecases.GetChampion
import com.example.usecases.UpdateFavouriteChampion
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class ChampionDetailActivityModule(private val championId: String) {

    @Provides
    fun championDetailViewModelProvider(
        getChampion: GetChampion,
        updateFavouriteChampion: UpdateFavouriteChampion
    ) = ChampionDetailViewModel(
        championId,
        getChampion,
        updateFavouriteChampion
    )

}

@Subcomponent(modules = [(ChampionDetailActivityModule::class)])
interface ChampionDetailActivityComponent {
    val championDetailViewModel: ChampionDetailViewModel
}

