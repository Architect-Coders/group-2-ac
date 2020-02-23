package com.example.usecases

import com.example.data.SummonersRepository
import com.example.domain.Summoner

class GetSummoner( private val summonersRepository: SummonersRepository) {
    suspend fun invoke(summonerName: String): Summoner?
            = summonersRepository.findSummonerByName(summonerName)
}