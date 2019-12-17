package com.teamtwo.apilol.model

import com.teamtwo.apilol.model.sumonners.Summoner
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

class SummonerRepository {
    suspend fun getSummoner(summonderName: String) = LOLServiceManager().serviceFindByName.getSummoner(summonderName)

}