package com.teamtwo.apilol.model.sumonners

import com.example.data.SummonerRemoteDataSource
import com.example.domain.Summoner
import com.teamtwo.apilol.model.LOLServiceManager

class SummonersRetrofitRemoteDataSource(
    private val apiKey: String,
    private val lolServiceManager: LOLServiceManager
): SummonerRemoteDataSource {

    override suspend fun getSummoner(summonerName: String): Summoner? =
        lolServiceManager.service.getSummoner(summonerName, apiKey).body()

}