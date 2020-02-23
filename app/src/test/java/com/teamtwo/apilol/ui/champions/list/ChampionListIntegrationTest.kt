package com.teamtwo.apilol.ui.champions.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.teamtwo.apilol.*
import com.teamtwo.apilol.di.champions.ChampionsComponent
import com.teamtwo.apilol.ui.champions.localChampion
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers

class ChampionListIntegrationTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private var observer: Observer<ChampionListViewModel.UiModel> = mock()
    private lateinit var viewModel: ChampionListViewModel
    private val component: TestComponent = DaggerTestComponent.factory().create()

    @Before
    fun setUp(){
        viewModel = component.plus(ChampionListActivityModule()).viewModel
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `data is loaded from server when local dataSource is empty`() = coroutinesTestRule.testDispatcher.runBlockingTest {

        viewModel.model.observeForever(observer)

        viewModel.refresh()

        verify(observer).onChanged(
            ArgumentMatchers.refEq(ChampionListViewModel.UiModel.Content(defaultFakeChampions))
        )

    }

    @ExperimentalCoroutinesApi
    @Test
    fun `data is loaded from local source when available`() = coroutinesTestRule.testDispatcher.runBlockingTest {

        val fakeLocalChampions = listOf(
            localChampion.copy(id = "id10"),
            localChampion.copy(id = "id10")
        )
        val localDataSource = component.localDataSource as FakeChampionsLocalDataSource
        localDataSource.champions = fakeLocalChampions

        viewModel.model.observeForever(observer)

        viewModel.refresh()

        verify(observer).onChanged(
            ArgumentMatchers.refEq(ChampionListViewModel.UiModel.Content(fakeLocalChampions))
        )
    }

}