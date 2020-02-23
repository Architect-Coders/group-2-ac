package com.example.usecases

import com.example.data.ChampionsRepository
import com.example.domain.Champion

class UpdateFavouriteChampion(
    private val championsRepository: ChampionsRepository
) {
    suspend fun invoke(champion: Champion): Champion =
        champion.copy(favourite = !champion.favourite).also {
            championsRepository.updateChampion(it)
        }
}