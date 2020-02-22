package com.example.data

import com.example.domain.Spell

class SpellsRepository(private val localDataSource:SpellsLocalDataSource,
                       private val remoteDataSource: SpellsRemoteDataSource) {

    suspend fun getSpells(): List<Spell> {
        if (localDataSource.isSpellsEmpty()){
            val spells = remoteDataSource.getSpelles()
            localDataSource.saveSpells(spells)
        }

        return localDataSource.getSpells()
    }
}

interface SpellsLocalDataSource {
    suspend fun saveSpells(spells: List<Spell>)
    suspend fun isSpellsEmpty(): Boolean
    suspend fun getSpells(): List<Spell>


}

interface SpellsRemoteDataSource {
    suspend fun getSpelles(): List<Spell>
}