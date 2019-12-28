package com.teamtwo.apilol.summoners

import androidx.lifecycle.*
import com.teamtwo.apilol.model.SummonerRepository
import com.teamtwo.apilol.model.sumonners.Summoner
import kotlinx.coroutines.launch

class SummonnerViewModel(private val summonerRepository: SummonerRepository) : ViewModel() {

    sealed class UiModelSummoner {
        object Loading : UiModelSummoner()
        object Error : UiModelSummoner()
        class Content(val summoner: Summoner): UiModelSummoner()
    }


    private val _model = MutableLiveData<UiModelSummoner>()
    val model: LiveData<UiModelSummoner>
        get() =  _model

    fun reload(name: String) {
        viewModelScope.launch {
            _model.value = UiModelSummoner.Loading
            val summonerResponse = summonerRepository.getSummoner(name).body()
            summonerResponse?.let {
                _model.value = UiModelSummoner.Content(it)
            } ?: run {
                _model.value = UiModelSummoner.Error
            }
        }
    }

}

class SumonnerViewModelFactory(private val repository: SummonerRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = SummonnerViewModel(repository) as T
}