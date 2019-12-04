package com.teamtwo.apilol.model

class ChampionsRepository {

    suspend fun getChampions() = LOLServiceManager().service.getChampions()
}