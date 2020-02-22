package com.example.usecases

import com.example.data.SpellsRepository
import com.example.domain.Spell

class GetSpells(private val spellsRepository: SpellsRepository) {
    suspend fun invoke() : List<Spell> = spellsRepository.getSpells()
}