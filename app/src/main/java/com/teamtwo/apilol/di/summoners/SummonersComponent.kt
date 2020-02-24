package com.teamtwo.apilol.di.summoners

import android.app.Application
import com.teamtwo.apilol.di.DataSourcesModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules= [
    SummonersAppModule::class,
    SummonersDataModule::class,
    SummonersUseCaseModule::class,
    DataSourcesModule::class])
interface SummonersComponent {

    //fun plus(matchesListActivityModule: MatchesListActivityModule): MatchesListActivityComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): SummonersComponent
    }
}