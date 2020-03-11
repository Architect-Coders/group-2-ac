package com.teamtwo.apilol.ui.matches

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.domain.FeaturedGameInfo
import com.example.usecases.GetMatches
import com.nhaarman.mockitokotlin2.*
import com.teamtwo.apilol.CoroutinesTestRule
import com.teamtwo.apilol.captureValues
import kotlinx.coroutines.*
import org.junit.*
import org.mockito.ArgumentMatchers
import org.mockito.InOrder
import org.mockito.internal.InOrderImpl
import org.mockito.internal.verification.Times

class MatchViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val useCase: GetMatches = mock()
    private val observer: Observer<MatchViewModel.MatchListUiData> = mock()
    private lateinit var viewModel: MatchViewModel

    @Before
    fun setUp() {
        viewModel = MatchViewModel(useCase)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `initialise viewmodel automatically propagates loading state`(): Unit = coroutinesTestRule.runBlocking {

        val mockData = emptyList<FeaturedGameInfo>() to listOf(localMatch)
        whenever(useCase.invoke()).doReturn(mockData)

        viewModel.uiState.captureValues {
            viewModel.requestRecentMatches()
            assertSendsValues(
                5,
                MatchViewModel.MatchListUiData.Loading(),
                MatchViewModel.MatchListUiData.Error("Ha ocurrido un error al recuperar las partidas.", listOf(localMatch))
            )
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `initialise viewmodel requests data to the usecase`(): Unit = coroutinesTestRule.runBlocking {

        viewModel.requestRecentMatches()
        verify(useCase, Times(1)).invoke()
        Unit
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `receiving an empty recent list propagates error state`(): Unit = coroutinesTestRule.runBlocking {

        val mockData = emptyList<FeaturedGameInfo>() to listOf(localMatch)

        whenever(useCase.invoke()).doReturn(mockData)

        viewModel.uiState.captureValues {
            viewModel.requestRecentMatches()
            assertSendsValues(
                100,
                MatchViewModel.MatchListUiData.Loading(),
                MatchViewModel.MatchListUiData.Error("Ha ocurrido un error al recuperar las partidas.", listOf(localMatch)))

        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `receiving recent and old data propagates data received state`(): Unit = coroutinesTestRule.runBlocking {
        val mockData = listOf(localMatch) to listOf(localMatch)
        whenever(useCase.invoke()).doReturn(mockData)
        viewModel.uiState.captureValues {
            viewModel.requestRecentMatches()
            assertSendsValues(
                100,
                MatchViewModel.MatchListUiData.Loading(),
                MatchViewModel.MatchListUiData.Data(MatchViewModel.MatchListUiModel(listOf(localMatch), listOf(localMatch))))
        }
    }
}