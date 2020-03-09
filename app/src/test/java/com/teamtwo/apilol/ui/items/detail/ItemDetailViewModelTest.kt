package com.teamtwo.apilol.ui.items.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.domain.Item
import com.example.usecases.GetItem
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

class ItemDetailViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val itemId = "id"
    private val getItem: GetItem = mock()
    private val observer: Observer<Item> = mock()

    private val viewModel: ItemDetailViewModel
            = ItemDetailViewModel(itemId, getItem)

    @ExperimentalCoroutinesApi
    @Test
    fun `observes the item liveData finds the item`() = coroutinesTestRule.testDispatcher.runBlockingTest {

        val item = localItem.copy(id = 1)

        whenever(getItem.invoke(itemId)).doReturn(item)

        viewModel.item.observeForever(observer)

        verify(observer).onChanged(item)

    }
}