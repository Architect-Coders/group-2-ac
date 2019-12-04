package com.teamtwo.apilol.champions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.teamtwo.apilol.Scope
import com.teamtwo.apilol.model.ChampionsRepository
import com.teamtwo.apilol.model.champions.Champion
import kotlinx.coroutines.launch

class ChampionListViewModel(private val championsRepository: ChampionsRepository)
    : ViewModel(), Scope by Scope.Impl() {

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val champions: List<Champion>): UiModel()
        class Navigation(val champion: Champion): UiModel()
    }

    init {
        initScope()
    }

    private val _model = MutableLiveData<UiModel>()

    val model: LiveData<UiModel> get() {
        if (_model.value == null) refresh()
        return _model
    }

    private fun refresh(){
        launch {
            _model.value = UiModel.Loading
            val championsResponse = championsRepository.getChampions()
            val championList = championsResponse.body()?.data?.values?.toList()
            _model.value = UiModel.Content(championList ?: emptyList())
        }
    }

    fun onMovieClicked(champion: Champion){
        _model.value = UiModel.Navigation(champion)
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}

class ChampionListViewModelFactory(private val repository: ChampionsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = ChampionListViewModel(repository) as T
}