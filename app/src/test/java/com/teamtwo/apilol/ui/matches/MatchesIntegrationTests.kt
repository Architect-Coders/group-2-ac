package com.teamtwo.apilol.ui.matches

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.data.MatchesLocalDataSource
import com.example.data.MatchesRemoteDataSource
import com.example.data.MatchesRepository
import com.example.usecases.GetMatches
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.teamtwo.apilol.CoroutinesTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import org.mockito.internal.verification.Times

class MatchesIntegrationTests {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    //Integración con dataSources
    private val localSource: MatchesLocalDataSource = mock()
    private val remoteSource: MatchesRemoteDataSource = mock()
    private val repository = MatchesRepository(localSource, remoteSource)
    private val useCase: GetMatches = GetMatches(repository)
    private val viewModelDataSource: MatchViewModel = MatchViewModel(useCase)

    //Integración con repository
    private val mockedRepository: MatchesRepository = mock()
    private val useCaseWithMockRepo: GetMatches = GetMatches(mockedRepository)
    private val viewModelRepository: MatchViewModel = MatchViewModel(useCaseWithMockRepo)

    //Integración con useCase
    private val mockedUseCase: GetMatches = mock()
    private val viewModelUseCase: MatchViewModel = MatchViewModel(mockedUseCase)

    @ExperimentalCoroutinesApi
    @Test
    fun `requesting data from viewmodel asks the usecase for it`(): Unit = coroutinesTestRule.runBlocking {

        viewModelUseCase.requestRecentMatches()
        verify(mockedUseCase, Times(1)).invoke()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `the usecase communicates with the repository to get data`(): Unit = coroutinesTestRule.runBlocking {

        viewModelRepository.requestRecentMatches()
        verify(mockedRepository, Times(1)).getMatches()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `the repository merges local and remote data`(): Unit = coroutinesTestRule.runBlocking {

        val mockMatches = listOf(localMatch)
        viewModelDataSource.requestRecentMatches()
        verify(localSource, Times(1)).saveMatches(mockMatches)
        verify(remoteSource, Times(1)).getMatches()
    }


}