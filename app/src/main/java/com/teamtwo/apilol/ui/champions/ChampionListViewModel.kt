package com.teamtwo.apilol.ui.champions

import androidx.lifecycle.*
import com.teamtwo.apilol.model.ChampionsRepository
import com.teamtwo.apilol.model.champions.Champion
import com.teamtwo.apilol.model.database.entities.ChampionEntity
import kotlinx.coroutines.launch

class ChampionListViewModel(private val championsRepository: ChampionsRepository) : ViewModel() {

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val champions: List<ChampionEntity>): UiModel()
        class Navigation(val champion: ChampionEntity): UiModel()
    }

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel> = _model

    fun refresh(){
        viewModelScope.launch {
            _model.value = UiModel.Loading
            _model.value = UiModel.Content(championsRepository.getChampions())
        }
    }

    fun onChampionClicked(champion: ChampionEntity){
        _model.value = UiModel.Navigation(champion)
    }
}

class ChampionListViewModelFactory(private val repository: ChampionsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = ChampionListViewModel(repository) as T
}