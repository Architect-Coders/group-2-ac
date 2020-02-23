package com.example.usecases

import com.example.data.ChampionsRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetChampionTest {

    private val championsRepository: ChampionsRepository = mock()
    private lateinit var getChampion: GetChampion

    @Before
    fun setUp(){
        getChampion = GetChampion(championsRepository)
    }

    @Test
    fun `getChampion return the correct requested champion`(){
        runBlocking {
            whenever(championsRepository.findChampionById(localChampion.id)).doReturn(localChampion)

            val champion = getChampion.invoke(localChampion.id)

            assertEquals(localChampion, champion)
        }
    }
}