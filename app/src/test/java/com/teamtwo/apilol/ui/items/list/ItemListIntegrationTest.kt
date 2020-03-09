package com.teamtwo.apilol.ui.items.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.teamtwo.apilol.*
import com.teamtwo.apilol.ui.items.localItem
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers

class ItemListIntegrationTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private var observer: Observer<ItemListViewModel.UiModel> = mock()
    private lateinit var viewModel: ItemListViewModel
    private val component: ItemTestComponent = DaggerTestComponent.factory().create()

    @Before
    fun setUp(){
        viewModel = component.plus(ItemListActivityModule()).viewModel
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `data is loaded from server when local dataSource is empty`() = coroutinesTestRule.testDispatcher.runBlockingTest {

        viewModel.model.observeForever(observer)

        viewModel.refresh()

        verify(observer).onChanged(
            ArgumentMatchers.refEq(ItemListViewModel.UiModel.Content(defaultFakeItems))
        )

    }

    @ExperimentalCoroutinesApi
    @Test
    fun `data is loaded from local source when available`() = coroutinesTestRule.testDispatcher.runBlockingTest {

        val fakeLocalItems = listOf(
            localItem.copy(id = 1),
            localItem.copy(id = 2)
        )
        val localDataSource = component.localDataSource as FakeItemsLocalDataSource
        localDataSource.items = fakeLocalItems

        viewModel.model.observeForever(observer)

        viewModel.refresh()

        verify(observer).onChanged(
            ArgumentMatchers.refEq(ItemListViewModel.UiModel.Content(fakeLocalItems))
        )
    }

}