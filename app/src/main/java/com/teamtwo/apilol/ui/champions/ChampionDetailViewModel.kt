package com.teamtwo.apilol.ui.champions

import androidx.lifecycle.*
import com.teamtwo.apilol.model.ChampionsRepository
import com.teamtwo.apilol.model.database.entities.ChampionEntity
import kotlinx.coroutines.launch

class ChampionDetailViewModel(
    private val championId: String,
    private val repository: ChampionsRepository) : ViewModel() {

    private val _champion = MutableLiveData<ChampionEntity>()
    val champion: LiveData<ChampionEntity>
        get() {
            if (_champion.value == null) findChampionById(championId)
            return _champion
        }

    fun onFavouriteClicked() = viewModelScope.launch {
        _champion.value?.let {
            val updatedChampion = it.copy(favourite = !it.favourite)
            _champion.value = updatedChampion
            repository.updateChampion(updatedChampion)
        }
    }

    private fun findChampionById(championId: String) = viewModelScope.launch {
        _champion.value = repository.findChampionById(championId)
    }

}

class ChampionDetailViewModelFactory(private val championId: String, private val repository: ChampionsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = ChampionDetailViewModel(championId, repository) as T
}