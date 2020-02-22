package com.teamtwo.apilol.model.sumonners

import com.example.data.RemoteSummonerDataSource
import com.example.domain.Summoner
import com.teamtwo.apilol.model.LOLServiceManager

class SummonersRetrofitDataSource(
    private val apiKey: String,
    private val lolServiceManager: LOLServiceManager
): RemoteSummonerDataSource {

    override suspend fun getSummoner(summonerName: String): Summoner? =
        lolServiceManager.service.getSummoner(summonerName, apiKey).body()

}