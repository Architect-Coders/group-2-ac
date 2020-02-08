package com.example.usecases

import com.example.data.ChampionsRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetChampionsTest {

    private val championsRepository: ChampionsRepository = mock()
    private lateinit var getChampions: GetChampions

    @Before
    fun setUp(){
        getChampions = GetChampions(championsRepository)
    }

    @Test
    fun `getChampions returns the correct requested champion list`(){
        runBlocking {

            val championsList = listOf(localChampion)

            whenever(championsRepository.getChampions()).doReturn(championsList)

            val champions = getChampions.invoke()

            Assert.assertEquals(championsList, champions)
        }
    }
}