package com.example.usecases

import com.example.data.ChampionsRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class UpdateFavouriteChampionTest {

    private val championsRepository: ChampionsRepository = mock()
    private lateinit var updateFavouriteChampion: UpdateFavouriteChampion

    @Before
    fun setUp(){
        updateFavouriteChampion = UpdateFavouriteChampion(championsRepository)
    }

    @Test
    fun `updateFavouriteChampion calls repository with correct values in champion`(){
        runBlocking {
            val result = updateFavouriteChampion.invoke(localChampion)

            verify(championsRepository).updateChampion(result)
        }
    }

    @Test
    fun `favourite champion becomes unfavourite`(){
        runBlocking {
            val result = updateFavouriteChampion.invoke(localChampion.copy(favourite = true))
            assertFalse(result.favourite)
        }
    }

    @Test
    fun `unfavourite champion becomes favourite`(){
        runBlocking {
            val result = updateFavouriteChampion.invoke(localChampion.copy(favourite = false))
            assertTrue(result.favourite)
        }
    }
}