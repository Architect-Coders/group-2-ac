package com.example.usecases

import com.example.data.ChampionsRepository
import com.example.domain.Champion

class GetChampion(
    private val championsRepository: ChampionsRepository
) {
    suspend fun invoke(championId: String): Champion
            = championsRepository.findChampionById(championId)
}