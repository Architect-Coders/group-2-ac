package com.teamtwo.apilol.summoners

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.teamtwo.apilol.Scope
import com.teamtwo.apilol.model.SummonerRepository
import com.teamtwo.apilol.model.sumonners.Summoner
import kotlinx.coroutines.launch

class SummonnerViewModel(private val summonerRepository: SummonerRepository) : ViewModel(), Scope by Scope.Impl() {

    sealed class UiModelSummoner {
        object Loading : UiModelSummoner()
        object Error : UiModelSummoner()
        class Content(val summoner: Summoner): UiModelSummoner()
    }

    init {
        initScope()
    }

    private val _model = MutableLiveData<UiModelSummoner>()
    val model: LiveData<UiModelSummoner>
        get() =  _model

    fun reload(name: String) {
        launch {
            _model.value = UiModelSummoner.Loading
            val championsResponse = summonerRepository.getSummoner(name).body()
            championsResponse?.let {
                _model.value = UiModelSummoner.Content(it)
            } ?: run {
                _model.value = UiModelSummoner.Error
            }
        }
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}

class SumonnerViewModelFactory(private val repository: SummonerRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = SummonnerViewModel(repository) as T
}