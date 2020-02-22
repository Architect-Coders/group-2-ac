package com.teamtwo.apilol.model.matches

import com.example.data.MatchesRemoteDataSource
import com.example.domain.FeaturedGameInfo
import com.teamtwo.apilol.model.LOLServiceManager

class MatchesRetrofitDataSource (private val apiKey: String): MatchesRemoteDataSource {

    override suspend fun getMatches(): List<FeaturedGameInfo> {
        val matches = LOLServiceManager().apiService.featuredGamesAsync(apiKey)
        return matches.body()?.mapResponseData() ?: emptyList()
    }
}