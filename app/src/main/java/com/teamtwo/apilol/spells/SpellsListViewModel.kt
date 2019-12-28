package com.teamtwo.apilol.spells

import androidx.lifecycle.*
import com.teamtwo.apilol.model.SpellsRepository
import com.teamtwo.apilol.model.spells.Spell
import kotlinx.coroutines.launch

class SpellsListViewModel(private val spellsRepository : SpellsRepository) : ViewModel() {

    sealed class  ViewState{
        object Loading : ViewState()
        class ShowList(val spells: List<Spell>): ViewState()
        class Navegation (val spell: Spell) : ViewState()
    }

    private  val _state = MutableLiveData<ViewState>()


    val state : LiveData<ViewState> get(){
        if( _state.value == null) refresh()
        return _state
    }

    fun onSpellClicked(spell: Spell){
        _state.value = ViewState.Navegation(spell)
    }

    private fun refresh() {
        viewModelScope.launch {
            _state.value = ViewState.Loading
            val spellsResponse = spellsRepository.getSpells()
            val spellsList = spellsResponse.body()?.data?.values?.toList()
            _state.value = ViewState.ShowList(spellsList?: emptyList())
        }
    }



    class SpellsListViewModelFactory(private val repository: SpellsRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T
                = SpellsListViewModel(repository) as T
    }
}