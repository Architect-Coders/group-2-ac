package com.teamtwo.apilol.ui.summoners

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.usecases.GetSummoner
import com.nhaarman.mockitokotlin2.*
import com.teamtwo.apilol.CoroutinesTestRule
import com.teamtwo.apilol.captureValues
import kotlinx.coroutines.*
import org.junit.*
import org.mockito.internal.verification.Times

class SummonerViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    private val defaultSummoner: String = "Irthael"

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val useCase: GetSummoner = mock()
    private val observer: Observer<SummonerViewModel.UiModelSummoner> = mock()
    private lateinit var viewModel: SummonerViewModel

    @Before
    fun setUp() {
        viewModel = SummonerViewModel(useCase)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `initialise viewmodel automatically propagates loading state`(): Unit = coroutinesTestRule.runBlocking {

        val mockData = localSummoner
        whenever(useCase.invoke(defaultSummoner)).doReturn(mockData)

        viewModel.model.captureValues {
            viewModel.reload(defaultSummoner)
            assertSendsValues(
                5,
                SummonerViewModel.UiModelSummoner.Loading(),
                SummonerViewModel.UiModelSummoner.Error("Ese nombre de usuario no existe ")
            )
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `initialise viewmodel requests data to the usecase`(): Unit = coroutinesTestRule.runBlocking {

        viewModel.model
        verify(useCase, Times(1)).invoke(defaultSummoner)
        Unit
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `receiving summoner`(): Unit = coroutinesTestRule.runBlocking {
        val mockData = localSummoner
        whenever(useCase.invoke(defaultSummoner)).doReturn(mockData)
        viewModel.model.captureValues {
            viewModel.reload(defaultSummoner)
            assertSendsValues(
                100,
                SummonerViewModel.UiModelSummoner.Loading(),
                SummonerViewModel.UiModelSummoner.Content(localSummoner))
        }
    }
}