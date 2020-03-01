package com.example.data

import com.example.domain.Summoner

class SummonersRepository(private val remoteSummonerDataSource: RemoteSummonerDataSource ){
    suspend fun findSummonerByName(summonerName: String): Summoner?
            = remoteSummonerDataSource.getSummoner(summonerName)
}

interface RemoteSummonerDataSource {
    suspend fun getSummoner(summonerName: String): Summoner?
}
