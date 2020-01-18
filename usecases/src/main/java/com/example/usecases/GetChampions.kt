package com.example.usecases

import com.example.data.ChampionsRepository
import com.example.domain.Champion

class GetChampions(
    private val championsRepository: ChampionsRepository
) {
    suspend fun invoke(): List<Champion> = championsRepository.getChampions()
}
