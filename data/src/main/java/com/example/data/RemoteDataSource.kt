package com.example.data

import com.example.domain.Champion
import com.example.domain.FeaturedGameInfo

interface RemoteDataSource {

    //Champions
    suspend fun getChampions(): List<Champion>

    //Matches
    suspend fun getMatches(apiKey: String): List<FeaturedGameInfo>
}