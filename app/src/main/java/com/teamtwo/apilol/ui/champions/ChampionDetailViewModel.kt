package com.teamtwo.apilol.ui.champions

import androidx.lifecycle.*
import com.example.domain.Champion
import com.example.usecases.GetChampion
import com.example.usecases.UpdateChampion
import kotlinx.coroutines.launch

class ChampionDetailViewModel(
    private val championId: String,
    private val getChampion: GetChampion,
    private val updateChampion: UpdateChampion) : ViewModel() {

    private val _champion = MutableLiveData<Champion>()
    val champion: LiveData<Champion>
        get() {
            if (_champion.value == null) findChampionById(championId)
            return _champion
        }

    fun onFavouriteClicked() = viewModelScope.launch {
        _champion.value?.let { _champion.value = updateChampion.invoke(it) }
    }

    private fun findChampionById(championId: String) = viewModelScope.launch {
        _champion.value = getChampion.invoke(championId)
    }
}

class ChampionDetailViewModelFactory(
    private val championId: String,
    private val getChampion: GetChampion,
    private val updateChampion: UpdateChampion)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = ChampionDetailViewModel(championId, getChampion, updateChampion) as T
}