package com.teamtwo.apilol.model.champions

import com.example.data.LocalDataSource
import com.teamtwo.apilol.model.database.ApiLolDatabase
import com.teamtwo.apilol.model.database.entities.ChampionEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.domain.Champion as ChampionDomain

class RoomDataSource(database: ApiLolDatabase) : LocalDataSource {

    private val dao = database.apiLolDao()

    override suspend fun areChampionsEmpty(): Boolean = withContext(Dispatchers.IO) {
        dao.numberOfChampions() <= 0
    }

    override suspend fun saveChampions(champions: List<ChampionDomain>) = withContext(Dispatchers.IO) {
        dao.insertChampions(champions.map(ChampionDomain::toChampionEntity))
    }

    override suspend fun getChampions(): List<ChampionDomain> = withContext(Dispatchers.IO){
        dao.getAllChampions().map(ChampionEntity::toChampionDomain)
    }

    override suspend fun updateChampion(champion: ChampionDomain) = withContext(Dispatchers.IO){
        dao.updateChampion(champion.toChampionEntity())
    }

    override suspend fun findChampionById(championId: String): ChampionDomain = withContext(Dispatchers.IO){
        dao.findChampionById(championId).toChampionDomain()
    }
}