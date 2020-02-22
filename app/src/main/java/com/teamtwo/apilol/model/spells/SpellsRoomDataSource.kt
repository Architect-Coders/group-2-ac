package com.teamtwo.apilol.model.spells

import com.example.data.SpellsLocalDataSource
import com.example.domain.Spell
import com.teamtwo.apilol.model.database.ApiLolDatabase
import com.teamtwo.apilol.model.database.entities.SpellsEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SpellsRoomDataSource(database: ApiLolDatabase) : SpellsLocalDataSource {

    private val dao = database.apiLolDao()

    override suspend fun saveSpells(spells: List<Spell>) = withContext(Dispatchers.IO) {
        dao.insertSpells(spells.map(Spell::toEntity))
    }

    override suspend fun isSpellsEmpty(): Boolean = withContext(Dispatchers.IO){
         dao.isSpellsEmpty() == 0
    }

    override suspend fun getSpells(): List<Spell> = withContext(Dispatchers.IO) {
        dao.getSpells().map(SpellsEntity::toDomain)
    }
}