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

class GetSummonersTest {

    private val repository: SummonersRepository = mock()
    private lateinit var useCase: GetSummoner

    @Before
    fun setUp() {
        useCase = GetSummoner(repository)
    }

    @Test
    fun `useCase ask repository for data`(): Unit = runBlocking {
        useCase.invoke("Irthael")
        verify(repository, Times(1)).findSummonerByName("Irthael")
        Unit
    }

    @Test
    fun `useCase returns both lists`(): Unit = runBlocking {

        val mockSummoner = localSummoner
        whenever(repository.findSummonerByName("Irthael")).doReturn(mockSummoner to mockSummoner)

        val data = useCase.invoke("Irthael")

        Assert.assertEquals(mockSummoner to mockSummoner, data)
    }

    @After
    fun tearDown() {
    }
}