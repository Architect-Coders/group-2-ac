package com.teamtwo.apilol.ui.champions

import androidx.lifecycle.*
import com.example.domain.Champion
import com.example.usecases.GetChampions
import kotlinx.coroutines.launch

class ChampionListViewModel(private val getChampions: GetChampions) : ViewModel() {

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val champions: List<Champion>): UiModel()
        class Navigation(val champion: Champion): UiModel()
    }

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel> = _model

    fun refresh(){
        viewModelScope.launch {
            _model.value = UiModel.Loading
            _model.value = UiModel.Content(getChampions.invoke())
        }
    }

    fun onChampionClicked(champion: Champion){
        _model.value = UiModel.Navigation(champion)
    }
}

class ChampionListViewModelFactory(private val getChampions: GetChampions) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = ChampionListViewModel(getChampions) as T
}