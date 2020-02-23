package com.teamtwo.apilol.model

import com.teamtwo.apilol.BuildConfig

class SummonerRepository {

    companion object {
        const val apiKey = BuildConfig.API_KEY
    }

    //TODO
    suspend fun getSummoner(summonderName: String) = LOLServiceManager("","").apiService.getSummoner(summonderName, apiKey)
}