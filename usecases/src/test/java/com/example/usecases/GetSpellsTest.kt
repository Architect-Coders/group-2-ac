package com.example.usecases

import com.example.data.SpellsRepository
import com.example.domain.Spell
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GetSpellsTest {

    private val spellsRepository: SpellsRepository = mock()
    private lateinit var getSpells : GetSpells

    @Before
    fun setUp(){
        getSpells = GetSpells(spellsRepository)
    }

    @Test
    fun `get spells returns the correct request `(){
        runBlocking{
            // Given
            val repositoryResult: List<Spell> = mock()
            Mockito.`when`(spellsRepository.getSpells()).thenReturn(repositoryResult)

            // When
            val result = getSpells.invoke()
            // Then
            Assert.assertEquals(repositoryResult, result)

        }
    }

}