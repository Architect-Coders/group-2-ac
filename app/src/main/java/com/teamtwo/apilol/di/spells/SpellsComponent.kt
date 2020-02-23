package com.teamtwo.apilol.di.spells

import android.app.Application
import com.teamtwo.apilol.di.DataSourcesModule
import com.teamtwo.apilol.ui.spells.SpellListActivtyComponent
import com.teamtwo.apilol.ui.spells.SpellListActivtyModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
    SpellsAppModule::class,
    SpellsDataModule::class,
    SpellsUseCaseModule::class,
    DataSourcesModule::class
])
interface SpellsComponent {

    fun plus(spellListActivtyModule: SpellListActivtyModule): SpellListActivtyComponent

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance app: Application) : SpellsComponent
    }
}