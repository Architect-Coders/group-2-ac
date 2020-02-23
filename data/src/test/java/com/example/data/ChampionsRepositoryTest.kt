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

class ChampionsRepositoryTest {

    private val championsLocalDataSource: ChampionsLocalDataSource = mock()
    private val championsRemoteDataSource: ChampionsRemoteDataSource = mock()
    private lateinit var championsRepository: ChampionsRepository

    @Before
    fun setUp(){
        championsRepository = ChampionsRepository(championsLocalDataSource, championsRemoteDataSource)
    }

    @Test
    fun `getChampions calls remoteDataSource and save the result in localDataSource if localDataSource is empty`(){
        runBlocking {

            val listLocalChampions = listOf(localChampion)

            whenever(championsLocalDataSource.areChampionsEmpty()).doReturn(true)
            whenever(championsLocalDataSource.getChampions()).doReturn(listLocalChampions)

            val champions = championsRepository.getChampions()

            assertEquals(listLocalChampions, champions)
        }
    }

    @Test
    fun `getChampions save remote data in local data`(){
        runBlocking {
            whenever(championsLocalDataSource.areChampionsEmpty()).doReturn(true)

            val champions = championsRepository.getChampions()

            verify(championsLocalDataSource).saveChampions(champions)
        }
    }

    @Test
    fun `getChampions not call remoteDataSource if localDataSource is not empty`(){
        runBlocking {
            whenever(championsLocalDataSource.areChampionsEmpty()).doReturn(false)

            championsRepository.getChampions()

            verify(championsRemoteDataSource, Times(0)).getChampions()
        }
    }

    @Test
    fun `updateChampion calls updateChampion from localDataSource`(){
        runBlocking {
            championsRepository.updateChampion(localChampion)

            verify(championsLocalDataSource).updateChampion(localChampion)
        }
    }

    @Test
    fun `findChampionById calls findChampionById from localDataSource`(){
        runBlocking {
            championsRepository.findChampionById("")

            verify(championsLocalDataSource).findChampionById("")
        }
    }

    @After
    fun tearDown(){

    }

}