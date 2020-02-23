package com.teamtwo.apilol.di.matches

import com.example.data.MatchesRepository
import com.example.usecases.GetMatches
import dagger.Module
import dagger.Provides

@Module
class MatchesUseCaseModule {

    @Provides
    fun getMatchesProvider(matchesRepository: MatchesRepository) = GetMatches(matchesRepository)
}