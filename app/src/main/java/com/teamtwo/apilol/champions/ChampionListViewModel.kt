package com.teamtwo.apilol.champions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ChampionListViewModel : ViewModel() {

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val champions: List<String>): UiModel()
        class Navigation(val champion: String): UiModel()
    }

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel> get() {
        if (_model.value == null) refresh()
        return _model
    }

    private fun refresh(){
        //do api call
    }

    fun onMovieClicked(champion: String){
        _model.value = UiModel.Navigation(champion)
    }
}

class ChampionListViewModelFactory(/*private val championsRepository: ChampionRepository*/) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = ChampionListViewModel(/*championsRepository*/) as T
}