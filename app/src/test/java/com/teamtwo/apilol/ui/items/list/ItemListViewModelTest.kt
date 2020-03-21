package com.teamtwo.apilol.ui.items.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.domain.Item
import com.example.usecases.GetItems
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.teamtwo.apilol.CoroutinesTestRule
import com.teamtwo.apilol.ui.items.localItem
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers

class ItemListViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val getItems: GetItems = mock()
    private val observer: Observer<ItemListViewModel.UiModel> = mock()
    private val viewModel = ItemListViewModel(getItems)

    @ExperimentalCoroutinesApi
    @Test
    fun `refresh shows loading`() = coroutinesTestRule.testDispatcher.runBlockingTest {

        whenever(getItems.invoke()).doReturn(listOf())

        viewModel.model.observeForever(observer)

        viewModel.refresh()

        verify(observer).onChanged(ItemListViewModel.UiModel.Loading)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `refresh calls getItems`() = coroutinesTestRule.testDispatcher.runBlockingTest {

        val list = listOf<Item>()
        whenever(getItems.invoke()).doReturn(list)

        viewModel.model.observeForever(observer)

        viewModel.refresh()

        verify(observer).onChanged(
            ArgumentMatchers.refEq(
                ItemListViewModel.UiModel.Content(list)
            )
        )
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `onItemClicked calls uiModel navigation with the clicked item`() = coroutinesTestRule.testDispatcher.runBlockingTest{

        val clickedItem = localItem

        viewModel.model.observeForever(observer)

        viewModel.onItemClicked(clickedItem)

        verify(observer).onChanged(
            ArgumentMatchers.refEq(
                ItemListViewModel.UiModel.Navigation(clickedItem)
            )
        )
    }
}