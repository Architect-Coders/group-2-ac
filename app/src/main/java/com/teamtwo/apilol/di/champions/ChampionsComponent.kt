package com.teamtwo.apilol.di.champions

import android.app.Application
import com.teamtwo.apilol.ui.champions.detail.ChampionDetailActivityComponent
import com.teamtwo.apilol.ui.champions.detail.ChampionDetailActivityModule
import com.teamtwo.apilol.ui.champions.list.ChampionListActivityComponent
import com.teamtwo.apilol.ui.champions.list.ChampionListActivityModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
    ChampionsAppModule::class,
    ChampionsDataModule::class,
    ChampionsUseCaseModule::class
])
interface ChampionsComponent {

    fun plus(championListActivityModule: ChampionListActivityModule): ChampionListActivityComponent
    fun plus(championDetailActivityModule: ChampionDetailActivityModule): ChampionDetailActivityComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): ChampionsComponent
    }

}