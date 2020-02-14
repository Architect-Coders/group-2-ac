package com.teamtwo.apilol.uiSpells

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.domain.Champion
import com.example.domain.Spell
import com.example.usecases.GetChampions
import com.example.usecases.GetSpells
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.teamtwo.apilol.ui.spells.SpellsListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.ArgumentMatchers
import org.mockito.Mockito

class SpellsListViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val getSpell: GetSpells = mock()
    private val observer: Observer<SpellsListViewModel.ViewState> = mock()

    private val viewModel = SpellsListViewModel(getSpell)

    @Test
    fun `refresh  loading`() = coroutinesTestRule.testDispatcher.runBlockingTest {

        Mockito.`when`(getSpell.invoke()).doReturn(listOf())

        viewModel.state.observeForever(observer)

        viewModel.refresh()

        verify(observer).onChanged(SpellsListViewModel.ViewState.Loading)
    }


    @ExperimentalCoroutinesApi
    @Test
    fun `refresh calls getSpell`() = coroutinesTestRule.testDispatcher.runBlockingTest {

        val list = listOf<Spell>()
        whenever(getSpell.invoke()).doReturn(list)

        viewModel.state.observeForever(observer)

        viewModel.refresh()

        verify(observer).onChanged(
            ArgumentMatchers.refEq(
                SpellsListViewModel.ViewState.ShowList (list)
            )
        )
    }


    @ExperimentalCoroutinesApi
    @Test
    fun `navegate to detail Spell`() = coroutinesTestRule.testDispatcher.runBlockingTest{

        val spell = localSpells

        viewModel.state.observeForever(observer)

        viewModel.onSpellClicked(spell)

        verify(observer).onChanged(
            ArgumentMatchers.refEq(
                SpellsListViewModel.ViewState.Navegation(spell)
            )
        )
    }


}