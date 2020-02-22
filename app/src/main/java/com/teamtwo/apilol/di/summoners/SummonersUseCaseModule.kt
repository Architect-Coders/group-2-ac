package com.teamtwo.apilol.di.summoners

import com.example.data.SummonersRepository
import com.example.usecases.GetSummoner
import dagger.Module
import dagger.Provides

@Module
class SummonersUseCaseModule {

    @Provides
    fun getSummonersProvider(summonersRepository: SummonersRepository) = GetSummoner(summonersRepository)
}