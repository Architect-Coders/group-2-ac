package com.teamtwo.apilol.model

class SummonerRepository {
    suspend fun getSummoner(summonderName: String) = LOLServiceManager().apiService.getSummoner(summonderName)
}