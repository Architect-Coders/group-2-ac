package com.teamtwo.apilol.ui.champions.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.domain.Champion
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.teamtwo.apilol.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ChampionDetailIntegrationTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private var observer: Observer<Champion> = mock()
    private lateinit var viewModel: ChampionDetailViewModel
    private lateinit var localDataSource: FakeChampionsLocalDataSource
    private val component: TestComponent = DaggerTestComponent.factory().create()

    @Before
    fun setUp(){
        viewModel = component.plus(ChampionDetailActivityModule(defaultFakeChampions[0].id)).championDetailViewModel
        localDataSource = component.localDataSource as FakeChampionsLocalDataSource
        localDataSource.champions = defaultFakeChampions
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `observing LiveData finds the champion`() = coroutinesTestRule.testDispatcher.runBlockingTest {
        viewModel.champion.observeForever(observer)

        verify(observer).onChanged(defaultFakeChampions[0])
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `favorite is updated in local data source`() = coroutinesTestRule.testDispatcher.runBlockingTest {
        viewModel.champion.observeForever(observer)

        viewModel.onFavouriteClicked()

        assertTrue(localDataSource.findChampionById(defaultFakeChampions[0].id).favourite)
    }
}