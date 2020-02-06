package com.example.data

import com.example.domain.FeaturedGameInfo

class MatchesRepository (
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    companion object {
        const val apiKey = ""
    }

    suspend fun getMatches(): Pair<List<FeaturedGameInfo>, List<FeaturedGameInfo>> {

        val recentMatches = remoteDataSource.getMatches(apiKey).also {
            saveRequestedMatches(it)
        }

        return recentMatches to getOldMatches()
    }

    private suspend fun saveRequestedMatches(matches: List<FeaturedGameInfo>) {
        localDataSource.saveMatches(matches)
    }

    private suspend fun getOldMatches(): List<FeaturedGameInfo> {
        return if (localDataSource.hasOldMatches()) {
            localDataSource.getOldMatches()
        } else {
            emptyList()
        }
    }
}