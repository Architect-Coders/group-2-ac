package com.teamtwo.apilol.model

class ChampionsRepository {

    fun getChampions() = LOLServiceManager().service.getChampions()
}