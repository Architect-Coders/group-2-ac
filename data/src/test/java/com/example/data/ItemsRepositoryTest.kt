package com.example.data

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.internal.verification.Times

class ItemsRepositoryTest {

    private val itemsLocalDataSource: LocalDataSourceItems = mock()
    private val itemsRemoteDataSource: RemoteDataSourceItems = mock()
    private lateinit var itemsRepository: ItemsRepository

    @Before
    fun setUp(){
        itemsRepository = ItemsRepository(itemsLocalDataSource, itemsRemoteDataSource)
    }

    @Test
    fun `getItems calls remoteDataSource and save the result in localDataSource if localDataSource is empty`(){
        runBlocking {

            val listLocalItems = listOf(localItem)

            whenever(itemsLocalDataSource.itemsExists()).doReturn(true)
            whenever(itemsLocalDataSource.getItems()).doReturn(listLocalItems)

            val items = itemsRepository.getItems()

            assertEquals(listLocalItems, items)
        }
    }

    @Test
    fun `getItems save remote data in local data`(){
        runBlocking {
            whenever(itemsLocalDataSource.itemsExists()).doReturn(true)

            val items = itemsRepository.getItems()

            verify(itemsLocalDataSource).saveItems(items)
        }
    }

    @Test
    fun `getItems not call remoteDataSource if localDataSource is not empty`(){
        runBlocking {
            whenever(itemsLocalDataSource.itemsExists()).doReturn(false)

            itemsRepository.getItems()

            verify(itemsRemoteDataSource, Times(0)).getItems()
        }
    }

    @Test
    fun `findItemById calls findItemById from localDataSource`(){
        runBlocking {
            itemsRepository.findItemById("0")

            verify(itemsLocalDataSource).findItemById("0")
        }
    }

    @After
    fun tearDown(){

    }

}