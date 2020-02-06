package com.example.usecases

import com.example.data.MatchesRepository
import com.example.domain.FeaturedGameInfo

class GetMatches(
    private val matchesRepository: MatchesRepository
) {
    suspend fun invoke(): Pair<List<FeaturedGameInfo>, List<FeaturedGameInfo>> = matchesRepository.getMatches()
}