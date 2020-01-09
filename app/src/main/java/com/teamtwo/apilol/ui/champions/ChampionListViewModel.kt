package com.teamtwo.apilol.ui.champions

import androidx.lifecycle.*
import com.teamtwo.apilol.model.ChampionsRepository
import com.teamtwo.apilol.model.champions.Champion
import kotlinx.coroutines.launch

class ChampionListViewModel(private val championsRepository: ChampionsRepository) : ViewModel() {

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val champions: List<Champion>): UiModel()
        class Navigation(val champion: Champion): UiModel()
    }

    private val _model = MutableLiveData<UiModel>()

    val model: LiveData<UiModel> get() {
        if (_model.value == null) refresh()
        return _model
    }

    private fun refresh(){
        viewModelScope.launch {
            _model.value = UiModel.Loading
            val championsResponse = championsRepository.getChampions()
            val championList = championsResponse.body()?.data?.values?.toList()
            _model.value = UiModel.Content(championList ?: emptyList())
        }
    }

    fun onChampionClicked(champion: Champion){
        _model.value = UiModel.Navigation(champion)
    }
}

class ChampionListViewModelFactory(private val repository: ChampionsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = ChampionListViewModel(repository) as T
}