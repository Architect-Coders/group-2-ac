package com.example.data

import com.example.domain.Champion

class ChampionsRepository(
    private val championsLocalDataSource: ChampionsLocalDataSource,
    private val championsRemoteDataSource: ChampionsRemoteDataSource
){
    suspend fun getChampions(): List<Champion> {
        if (championsLocalDataSource.areChampionsEmpty()){
            val champions = championsRemoteDataSource.getChampions()
            championsLocalDataSource.saveChampions(champions)
        }

        return championsLocalDataSource.getChampions()
    }

    suspend fun updateChampion(champion: Champion){
        championsLocalDataSource.updateChampion(champion)
    }

    suspend fun findChampionById(championId: String): Champion
            = championsLocalDataSource.findChampionById(championId)
}

interface ChampionsLocalDataSource {
    suspend fun areChampionsEmpty(): Boolean
    suspend fun saveChampions(champions: List<Champion>)
    suspend fun getChampions(): List<Champion>
    suspend fun updateChampion(champion: Champion)
    suspend fun findChampionById(championId: String): Champion
}

interface ChampionsRemoteDataSource {
    suspend fun getChampions(): List<Champion>
}
