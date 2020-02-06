package com.example.data

import com.example.domain.Champion

class ChampionsRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
){
    suspend fun getChampions(): List<Champion> {
        if (localDataSource.areChampionsEmpty()){
            val champions = remoteDataSource.getChampions()
            localDataSource.saveChampions(champions)
        }

        return localDataSource.getChampions()
    }

    suspend fun updateChampion(champion: Champion){
        localDataSource.updateChampion(champion)
    }

    suspend fun findChampionById(championId: String): Champion
            = localDataSource.findChampionById(championId)
}
