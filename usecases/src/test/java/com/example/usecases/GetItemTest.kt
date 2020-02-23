package com.example.usecases

import com.example.data.ItemsRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetItemTest {

    private val itemsRepository: ItemsRepository = mock()
    private lateinit var getItem: GetItem

    @Before
    fun setUp(){
        getItem = GetItem(itemsRepository)
    }

    @Test
    fun `getItem return the correct requested item`(){
        runBlocking {
            whenever(itemsRepository.findItemById(localItem.id.toString())).doReturn(localItem)

            val item = getItem.invoke(localItem.id.toString())

            assertEquals(localItem, item)
        }
    }
}