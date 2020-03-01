package com.teamtwo.apilol.ui.summoners

import androidx.lifecycle.*
import com.example.data.SummonersRepository
import com.example.domain.Summoner
import com.example.usecases.GetSummoner
import kotlinx.coroutines.launch

class SummonerViewModel(private val summonerRepository: GetSummoner) : ViewModel() {

    sealed class UiModelSummoner {
        data class Loading(val name: String = "") : UiModelSummoner()
        data class Error(val name: String = "") : UiModelSummoner()
        class Content(val summoner: Summoner): UiModelSummoner()
    }


    private val _model = MutableLiveData<UiModelSummoner>()
    val model: LiveData<UiModelSummoner>
        get() =  _model

    fun reload(name: String) {
        viewModelScope.launch {
            _model.value = UiModelSummoner.Loading()
            val summonerResponse = summonerRepository.invoke(name)
            summonerResponse?.let {
                _model.value = UiModelSummoner.Content(it)
            } ?: run {
                _model.value = UiModelSummoner.Error()
            }
        }
    }

}

class SumonnerViewModelFactory(private val repository: GetSummoner) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = SummonerViewModel(repository) as T
}