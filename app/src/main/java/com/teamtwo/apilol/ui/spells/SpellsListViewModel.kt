package com.teamtwo.apilol.ui.spells

import androidx.lifecycle.*
import com.example.data.SpellsRepository
import com.example.domain.Spell
import com.example.usecases.GetSpells
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SpellsListViewModel(private val getSpells: GetSpells ) : ViewModel() {

    sealed class  ViewState{
        object Loading : ViewState()
        class ShowList(val spells: List<Spell>): ViewState()
        class Navegation (val spell: Spell) : ViewState()
    }

    private val _state = MutableLiveData<ViewState>()
    val state: LiveData<ViewState> = _state
    
    fun onSpellClicked(spell: Spell){
        _state.value = ViewState.Navegation(spell)
    }

     fun refresh() {
         viewModelScope.launch {
             _state.value = ViewState.Loading
             val response  = withContext(Dispatchers.IO){getSpells.invoke()}
             _state.value = ViewState.ShowList(response)
         }
    }

}