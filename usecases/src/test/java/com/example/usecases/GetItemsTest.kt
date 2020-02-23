package com.example.usecases

import com.example.data.ItemsRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetItemsTest {

    private val itemsRepository: ItemsRepository = mock()
    private lateinit var getItems: GetItems

    @Before
    fun setUp(){
        getItems = GetItems(itemsRepository)
    }

    @Test
    fun `getItems returns the correct requested item list`(){
        runBlocking {

            val itemsList = listOf(localItem)

            whenever(itemsRepository.getItems()).doReturn(itemsList)

            val items = getItems.invoke()

            Assert.assertEquals(itemsList, items)
        }
    }
}