package com.example.data

import com.example.domain.FeaturedGameInfo

class MatchesRepository (
    private val localDataSource: MatchesLocalDataSource,
    private val remoteDataSource: MatchesRemoteDataSource
) {

    suspend fun getMatches(): Pair<List<FeaturedGameInfo>, List<FeaturedGameInfo>> {

        val recentMatches = remoteDataSource.getMatches().also {
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

interface MatchesLocalDataSource {
    suspend fun saveMatches(matches: List<FeaturedGameInfo>)
    suspend fun getOldMatches(): List<FeaturedGameInfo>
    suspend fun hasOldMatches(): Boolean
}

interface MatchesRemoteDataSource {
    suspend fun getMatches(): List<FeaturedGameInfo>
}