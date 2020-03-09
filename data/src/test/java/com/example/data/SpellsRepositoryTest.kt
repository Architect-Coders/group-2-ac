package com.example.data

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.internal.verification.Times

class SpellsRepositoryTest {

    private val localDataSource: SpellsLocalDataSource = mock()
    private val remoteDataSource: SpellsRemoteDataSource = mock()
    private lateinit var repository: SpellsRepository

    @Before
    fun setUp() {
        repository = SpellsRepository(localDataSource, remoteDataSource)
    }

    @Test
    fun `get spells always returns new data`(): Unit = runBlocking {

        val mockSpells = listOf(localSpells)

        whenever(localDataSource.isSpellsEmpty()).doReturn(true)
        whenever(localDataSource.getSpells()).doReturn(mockSpells)

        val spell = repository.getSpells()

        Assert.assertEquals(mockSpells, spell)


    }

    @Test
    fun `getSpells save remote data in local data`(){
        runBlocking {
            whenever(localDataSource.isSpellsEmpty()).doReturn(true)

            val champions = repository.getSpells()

            verify(localDataSource).saveSpells(champions)
        }
    }

    @Test
    fun `getSpell not call remoteDataSource if localDataSource is not empty`(){
        runBlocking {
            whenever(localDataSource.isSpellsEmpty()).doReturn(false)

            repository.getSpells()

            verify(remoteDataSource, Times(0)).getSpelles()
        }
    }



    @After
    fun tearDown(){

    }

}