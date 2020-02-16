package com.example.usecases

import com.example.data.MatchesRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
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

    @Test
    fun `useCase returns both lists`(): Unit = runBlocking {

        val mockList = listOf(localMatch)
        whenever(repository.getMatches()).doReturn(mockList to mockList)

        val data = useCase.invoke()

        Assert.assertEquals(mockList to mockList, data)
    }

    @After
    fun tearDown() {
    }
}