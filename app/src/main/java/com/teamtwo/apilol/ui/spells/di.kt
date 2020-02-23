package com.teamtwo.apilol.ui.spells

import com.example.usecases.GetSpells
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module

class SpellListActivtyModule {

    @Provides
    fun spellListViewModel(getSpells: GetSpells) = SpellsListViewModel(getSpells)
}
    @Subcomponent(modules = [(SpellListActivtyModule::class)])
    interface SpellListActivtyComponent {
        val viewModel: SpellsListViewModel
    }
