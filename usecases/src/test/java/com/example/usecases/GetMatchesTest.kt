package com.example.usecases

import com.example.data.MatchesRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.internal.verification.Times

class GetMatchesTest {

    private val repository: MatchesRepository = mock()
    private lateinit var useCase: GetMatches

    @Before
    fun setUp() {
        useCase = GetMatches(repository)
    }

    @Test
    fun `useCase ask repository for data`(): Unit = runBlocking {

        useCase.invoke()
        verify(repository, Times(1)).getMatches()
        Unit
    }

    @After
    fun tearDown() {
    }
}