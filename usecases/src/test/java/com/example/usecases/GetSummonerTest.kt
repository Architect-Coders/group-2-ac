package com.example.usecases

import com.example.data.SummonersRepository
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

class GetSummonerTest {

    private val repository: SummonersRepository = mock()
    private lateinit var useCase: GetSummoner
    private val defaultSummoner: String = "Irthael"

    @Before
    fun setUp() {
        useCase = GetSummoner(repository)
    }

    @Test
    fun `useCase ask repository for data`(): Unit = runBlocking {

        useCase.invoke(defaultSummoner)
        verify(repository, Times(1)).findSummonerByName(defaultSummoner)
        Unit
    }

    @Test
    fun `useCase returns summoner item`(): Unit = runBlocking {

        val mockItem = localSummoner
        whenever(repository.findSummonerByName(defaultSummoner)).doReturn(mockItem)

        val data = useCase.invoke(defaultSummoner)

        Assert.assertEquals(mockItem, data)
    }

    @After
    fun tearDown() {
    }
}