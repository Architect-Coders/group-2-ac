package com.example.data

import com.example.domain.FeaturedGameInfo
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class MatchesRepositoryTest {

    private val localDataSource: MatchesLocalDataSource = mock()
    private val remoteDataSource: MatchesRemoteDataSource = mock()
    private lateinit var repository: MatchesRepository

    @Before
    fun setUp() {
        repository = MatchesRepository(localDataSource, remoteDataSource)
    }

    @Test
    fun `get matches always returns new data`(): Unit = runBlocking {

        val mockMatches = listOf(localMatch)

        whenever(localDataSource.hasOldMatches()).doReturn(false)
        whenever(remoteDataSource.getMatches()).doReturn(mockMatches)

        val matches = repository.getMatches()

        assertEquals(mockMatches, matches.first)


    }

    @Test
    fun `get matches returns saved data`(): Unit = runBlocking {

        val localMatches = listOf(localMatch)

        whenever(localDataSource.hasOldMatches()).doReturn(true)
        whenever(localDataSource.getOldMatches()).doReturn(localMatches)

        val matches = repository.getMatches()

        assertEquals(localMatches, matches.second)
    }

    @Test
    fun `get matches without data saved returns empty list`(): Unit = runBlocking {

        whenever(localDataSource.hasOldMatches()).doReturn(false)

        val matches = repository.getMatches()

        assertEquals(emptyList<FeaturedGameInfo>(), matches.second)
    }

    @After
    fun tearDown() {

    }
}
