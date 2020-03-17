package com.example.usecases

import com.example.data.SpellsRepository
import com.example.domain.Spell
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.internal.verification.Times

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
          whenever(spellsRepository.getSpells()).thenReturn(repositoryResult)

            // When
            val result = getSpells.invoke()
            // Then
            Assert.assertEquals(repositoryResult, result)

        }
    }

    @Test
    fun `useCase ask repository for data`(): Unit = runBlocking {

        getSpells.invoke()
        verify(spellsRepository, Times(1)).getSpells()
        Unit
    }

}