package com.example.data

import com.example.domain.Champion
import com.example.domain.FeaturedGameInfo

interface LocalDataSource {

    //Champions
    suspend fun areChampionsEmpty(): Boolean
    suspend fun saveChampions(champions: List<Champion>)
    suspend fun getChampions(): List<Champion>
    suspend fun updateChampion(champion: Champion)
    suspend fun findChampionById(championId: String): Champion

    //Matches
    suspend fun saveMatches(matches: List<FeaturedGameInfo>)
    suspend fun getOldMatches(): List<FeaturedGameInfo>
    suspend fun hasOldMatches(): Boolean
}