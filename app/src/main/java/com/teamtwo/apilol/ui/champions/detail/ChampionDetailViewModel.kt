package com.teamtwo.apilol.ui.champions.detail

import androidx.lifecycle.*
import com.example.domain.Champion
import com.example.usecases.GetChampion
import com.example.usecases.UpdateFavouriteChampion
import kotlinx.coroutines.launch

class ChampionDetailViewModel(
    private val championId: String,
    private val getChampion: GetChampion,
    private val updateFavouriteChampion: UpdateFavouriteChampion) : ViewModel() {

    private val _champion = MutableLiveData<Champion>()
    val champion: LiveData<Champion>
        get() {
            if (_champion.value == null) findChampionById(championId)
            return _champion
        }

    fun onFavouriteClicked() = viewModelScope.launch {
        _champion.value?.let { _champion.value = updateFavouriteChampion.invoke(it) }
    }

    private fun findChampionById(championId: String) = viewModelScope.launch {
        _champion.value = getChampion.invoke(championId)
    }
}

class ChampionDetailViewModelFactory(
    private val championId: String,
    private val getChampion: GetChampion,
    private val updateFavouriteChampion: UpdateFavouriteChampion)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = ChampionDetailViewModel(
        championId,
        getChampion,
        updateFavouriteChampion
    ) as T
}