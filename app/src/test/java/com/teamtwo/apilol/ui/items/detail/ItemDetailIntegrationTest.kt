package com.teamtwo.apilol.ui.items.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.domain.Item
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.teamtwo.apilol.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ItemDetailIntegrationTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private var observer: Observer<Item> = mock()
    private lateinit var viewModel: ItemDetailViewModel
    private lateinit var localDataSource: FakeItemsLocalDataSource
    private val component: ItemTestComponent = DaggerItemTestComponent.factory().create()
    @Before
    fun setUp(){
        viewModel = component.plus(ItemDetailActivityModule(defaultFakeItems[0].id.toString())).itemDetailViewModel
        localDataSource = component.localDataSource as FakeItemsLocalDataSource
        localDataSource.items = defaultFakeItems
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `observing LiveData finds the item`() = coroutinesTestRule.testDispatcher.runBlockingTest {
        viewModel.item.observeForever(observer)

        verify(observer).onChanged(defaultFakeItems[0])
    }
}