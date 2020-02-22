package com.teamtwo.apilol.di.spells

import com.example.data.SpellsRepository
import com.example.domain.Spell
import com.example.usecases.GetSpells
import dagger.Module
import dagger.Provides


@Module
class SpellsUseCaseModule {


    @Provides
        fun getSpellsProvider(spellsRepository: SpellsRepository) = GetSpells(spellsRepository)


}