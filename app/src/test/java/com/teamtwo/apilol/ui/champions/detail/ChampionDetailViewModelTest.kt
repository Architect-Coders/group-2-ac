package com.teamtwo.apilol.ui.champions.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.domain.Champion
import com.example.usecases.GetChampion
import com.example.usecases.UpdateFavouriteChampion
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

class ChampionDetailViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val championId = "id"
    private val getChampion: GetChampion = mock()
    private val updateFavouriteChampion: UpdateFavouriteChampion = mock()
    private val observer: Observer<Champion> = mock()

    private val viewModel: ChampionDetailViewModel
            = ChampionDetailViewModel(championId, getChampion, updateFavouriteChampion)

    @ExperimentalCoroutinesApi
    @Test
    fun `observes the champion liveData finds the champion`() = coroutinesTestRule.testDispatcher.runBlockingTest {

        val champion = localChampion.copy(id = "id")

        whenever(getChampion.invoke(championId)).doReturn(champion)

        viewModel.champion.observeForever(observer)

        verify(observer).onChanged(champion)

    }

    @ExperimentalCoroutinesApi
    @Test
    fun `onFavouriteClicked calls updateFavouriteChampion and and champion value changes`() = coroutinesTestRule.testDispatcher.runBlockingTest {

        val champion = localChampion.copy(id = "id")
        val updatedChampion = champion.copy(favourite = !champion.favourite)

        whenever(getChampion.invoke(championId)).doReturn(champion)
        whenever(updateFavouriteChampion.invoke(champion)).thenReturn(updatedChampion)

        viewModel.champion.observeForever(observer)
        viewModel.onFavouriteClicked()

        verify(updateFavouriteChampion).invoke(champion)
        verify(observer).onChanged(updatedChampion)
    }

}