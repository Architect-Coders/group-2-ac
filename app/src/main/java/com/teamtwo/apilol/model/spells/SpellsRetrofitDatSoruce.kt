package com.teamtwo.apilol.model.spells

import com.example.data.SpellsRemoteDataSource
import com.example.domain.Spell
import com.teamtwo.apilol.model.LOLService
import com.teamtwo.apilol.model.LOLServiceManager

class SpellsRetrofitDatSoruce : SpellsRemoteDataSource {
    override suspend fun getSpelles(): List<Spell> {
        val spells = LOLServiceManager().service.getSpells()
        return spells.body()?.data?.values?.toList() ?: emptyList()
    }
}