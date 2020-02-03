package com.teamtwo.apilol.model.sumonners

import com.example.data.RemoteSummonerDataSource
import com.example.domain.Summoner
import com.teamtwo.apilol.model.LOLServiceManager

class RetrofitDataSource: RemoteSummonerDataSource {

    override suspend fun getSummoner(summonerName: String): Summoner? =
        LOLServiceManager().service.getSummoner(summonerName, "").body()

}