package com.teamtwo.apilol.di.matches

import android.app.Application
import com.teamtwo.apilol.ui.matches.MatchesListActivityComponent
import com.teamtwo.apilol.ui.matches.MatchesListActivityModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules= arrayOf(
    MatchesAppModule::class,
    MatchesDataModule::class,
    MatchesUseCaseModule::class
))
interface MatchesComponent {

    fun plus(matchesListActivityModule: MatchesListActivityModule): MatchesListActivityComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): MatchesComponent
    }
}