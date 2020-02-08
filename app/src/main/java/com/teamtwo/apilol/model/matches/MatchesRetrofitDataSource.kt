package com.teamtwo.apilol.model.matches

import com.example.data.MatchesRemoteDataSource
import com.example.domain.FeaturedGameInfo
import com.teamtwo.apilol.model.LOLServiceManager

class MatchesRetrofitDataSource: MatchesRemoteDataSource {

    override suspend fun getMatches(apiKey: String): List<FeaturedGameInfo> {
        val matches = LOLServiceManager().apiService.featuredGamesAsync(apiKey)
        return matches.body()?.mapResponseData() ?: emptyList()
    }
}