package com.example.data

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class SummonersRepositoryTest {

    private val summonerRemoteDataSource: SummonerRemoteDataSource = mock()
    private lateinit var summonerRepository: SummonersRepository

    @Before
    fun setUp(){
        summonerRepository = SummonersRepository(summonerRemoteDataSource)
    }


    @Test
    fun `findItemById calls findItemById from remoteSummonerDataSource`(){
        runBlocking {
            summonerRepository.findSummonerByName("Irthael")
            verify(summonerRepository).findSummonerByName("Irthael")
        }
    }

    @After
    fun tearDown(){
    }

}