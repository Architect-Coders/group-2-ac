package com.teamtwo.apilol.ui.summoners

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.data.*
import com.example.usecases.GetMatches
import com.example.usecases.GetSummoner
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.teamtwo.apilol.CoroutinesTestRule
import com.teamtwo.apilol.ui.matches.MatchViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import org.mockito.internal.verification.Times

class SummonersIntegrationTests {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    //Integración con dataSources
    private val remoteSource: RemoteSummonerDataSource = mock()
    private val repository = SummonersRepository(remoteSource)
    private val useCase: GetSummoner = GetSummoner(repository)
    private val viewModelDataSource: SummonerViewModel = SummonerViewModel(useCase)

    //Integración con repository
    private val mockedRepository: SummonersRepository = mock()
    private val useCaseWithMockRepo: GetSummoner = GetSummoner(mockedRepository)
    private val viewModelRepository: SummonerViewModel = SummonerViewModel(useCaseWithMockRepo)

    //Integración con useCase
    private val mockedUseCase: GetSummoner = mock()
    private val viewModelUseCase: SummonerViewModel = SummonerViewModel(mockedUseCase)

    @ExperimentalCoroutinesApi
    @Test
    fun `requesting data from viewmodel asks the usecase for it`(): Unit = coroutinesTestRule.runBlocking {

        viewModelUseCase.reload("Irthael")
        verify(mockedUseCase, Times(1)).invoke("Irthael")
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `the usecase communicates with the repository to get data`(): Unit = coroutinesTestRule.runBlocking {

        viewModelRepository.reload("Irthael")
        verify(mockedRepository, Times(1)).findSummonerByName("Irthael")
    }
}