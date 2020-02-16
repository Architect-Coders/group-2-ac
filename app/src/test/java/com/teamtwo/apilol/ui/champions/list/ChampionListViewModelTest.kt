package com.teamtwo.apilol.ui.champions.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.domain.Champion
import com.example.usecases.GetChampions
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.teamtwo.apilol.CoroutinesTestRule
import com.teamtwo.apilol.ui.champions.localChampion
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers

class ChampionListViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val getChampions: GetChampions = mock()
    private val observer: Observer<ChampionListViewModel.UiModel> = mock()
    private val viewModel = ChampionListViewModel(getChampions)

    @ExperimentalCoroutinesApi
    @Test
    fun `refresh shows loading`() = coroutinesTestRule.testDispatcher.runBlockingTest {

        whenever(getChampions.invoke()).doReturn(listOf())

        viewModel.model.observeForever(observer)

        viewModel.refresh()

        verify(observer).onChanged(ChampionListViewModel.UiModel.Loading)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `refresh calls getChampions`() = coroutinesTestRule.testDispatcher.runBlockingTest {

        val list = listOf<Champion>()
        whenever(getChampions.invoke()).doReturn(list)

        viewModel.model.observeForever(observer)

        viewModel.refresh()

        verify(observer).onChanged(
            ArgumentMatchers.refEq(
                ChampionListViewModel.UiModel.Content(list)
            )
        )
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `onChampionClicked calls uiModel navigation with the clicked champion`() = coroutinesTestRule.testDispatcher.runBlockingTest{

        val clickedChampion = localChampion

        viewModel.model.observeForever(observer)

        viewModel.onChampionClicked(clickedChampion)

        verify(observer).onChanged(
            ArgumentMatchers.refEq(
                ChampionListViewModel.UiModel.Navigation(clickedChampion)
            )
        )
    }
}