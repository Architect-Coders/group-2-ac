package com.example.data

import com.example.domain.Summoner

class SummonersRepository(private val summonerRemoteDataSource: SummonerRemoteDataSource ){
    suspend fun findSummonerByName(summonerName: String): Summoner?
            = summonerRemoteDataSource.getSummoner(summonerName)
}

interface SummonerRemoteDataSource {
    suspend fun getSummoner(summonerName: String): Summoner?
}
