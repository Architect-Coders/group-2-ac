package com.teamtwo.apilol.uiSpells

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.data.*
import com.example.usecases.GetSpells
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.teamtwo.apilol.ui.spells.SpellsListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import org.mockito.internal.verification.Times

class SpellsIntegrationsTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    //repository
    private val mockedRepository: SpellsRepository = mock()
    private val useCaseWithMockRepo: GetSpells = GetSpells(mockedRepository)
    private val viewModelRepository: SpellsListViewModel = SpellsListViewModel(useCaseWithMockRepo)

    //useCase
    private val mockedUseCase: GetSpells = mock()
    private val viewModelUseCase: SpellsListViewModel = SpellsListViewModel(mockedUseCase)

    @ExperimentalCoroutinesApi
    @Test
    fun `requesting data from viewmodel asks the usecase for it`(): Unit =
        coroutinesTestRule.runBlocking {

            viewModelUseCase.refresh()
            verify(mockedUseCase, Times(1)).invoke()
        }

    @ExperimentalCoroutinesApi
    @Test
    fun `the usecase communicates with the repository to get data`(): Unit =
        coroutinesTestRule.runBlocking {

            viewModelRepository.refresh()
            verify(mockedRepository, Times(1)).getSpells()
        }




}