package com.teamtwo.apilol.di.summoners

import android.app.Application
import com.teamtwo.apilol.ui.matches.MatchesListActivityComponent
import com.teamtwo.apilol.ui.matches.MatchesListActivityModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules= arrayOf(
    SummonersAppModule::class,
    SummonersDataModule::class,
    SummonersUseCaseModule::class
))
interface SummonersComponent {

    //fun plus(matchesListActivityModule: MatchesListActivityModule): MatchesListActivityComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): SummonersComponent
    }
}