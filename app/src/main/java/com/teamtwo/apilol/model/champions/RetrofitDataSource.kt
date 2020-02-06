package com.teamtwo.apilol.model.champions

import com.example.data.RemoteDataSource
import com.example.domain.FeaturedGameInfo
import com.example.domain.Champion as ChampionDomain
import com.teamtwo.apilol.model.LOLServiceManager

class RetrofitDataSource: RemoteDataSource {

    override suspend fun getChampions(): List<ChampionDomain> {
        val championsResponse = LOLServiceManager().service.getChampions()
        return championsResponse.body()?.data?.values?.toList() ?: emptyList()
    }

    override suspend fun getMatches(apiKey: String): List<FeaturedGameInfo> {
        val matches = LOLServiceManager().apiService.featuredGamesAsync(apiKey)
        return matches.body()?.mapResponseData() ?: emptyList()
    }
}
