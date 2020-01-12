package com.teamtwo.apilol.model

import com.teamtwo.apilol.ApiLolAplication
import com.teamtwo.apilol.model.champions.Champion
import com.teamtwo.apilol.model.database.entities.ChampionEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ChampionsRepository(application: ApiLolAplication) {

    private val db = application.db

    suspend fun getChampions(): List<ChampionEntity> = withContext(Dispatchers.IO) {
        if (db.apiLolDao().numberOfChampions() <= 0){
            val championsResponse = LOLServiceManager().service.getChampions()
            val championList = championsResponse.body()?.data?.values?.toList() ?: emptyList()
            db.apiLolDao().insertChampions(championList.map{ it.toChampionEntity() })
        }
        db.apiLolDao().getAllChampions()
    }

    suspend fun updateChampion(champion: ChampionEntity) = withContext(Dispatchers.IO) {
        db.apiLolDao().updateChampion(champion)
    }

    suspend fun findChampionById(championId: String): ChampionEntity = withContext(Dispatchers.IO) {
        db.apiLolDao().findChampionById(championId)
    }

    private fun Champion.toChampionEntity() = ChampionEntity(
        version,
        id,
        key,
        name,
        title,
        blurb,
        info,
        image,
        partype,
        stats,
        false
    )
}