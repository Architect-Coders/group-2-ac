package com.teamtwo.apilol.ui.summoners

import androidx.lifecycle.*
import com.example.domain.Summoner
import com.example.usecases.GetSummoner
import kotlinx.coroutines.launch

class SummonnerViewModel(
    private val summonerRepository: GetSummoner) : ViewModel() {

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
            /*
            val summonerResponse = summonerRepository.invoke(name)
            summonerResponse.let {
                _model.value = UiModelSummoner.Content(summonerResponse)
            }
            */


            val summonerResponse = summonerRepository.invoke(name)
            summonerResponse?.let {
                _model.value = UiModelSummoner.Content(it)
            } ?: run {
                _model.value = UiModelSummoner.Error
            }


        }
    }

}

class SumonnerViewModelFactory(private val repository: GetSummoner) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = SummonnerViewModel(repository) as T
}