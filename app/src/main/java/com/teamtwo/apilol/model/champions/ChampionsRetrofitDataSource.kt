package com.teamtwo.apilol.model.champions

import com.example.data.ChampionsRemoteDataSource
import com.example.domain.Champion
import com.teamtwo.apilol.model.LOLServiceManager

class ChampionsRetrofitDataSource: ChampionsRemoteDataSource {

    override suspend fun getChampions(): List<Champion> {
        val championsResponse = LOLServiceManager().service.getChampions()
        return championsResponse.body()?.data?.values?.toList() ?: emptyList()
    }
}
