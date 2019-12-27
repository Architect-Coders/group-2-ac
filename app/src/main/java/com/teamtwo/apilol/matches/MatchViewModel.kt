package com.teamtwo.apilol.matches

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MatchViewModel (private val useCase: GetFeaturedMatchesUseCase): ViewModel() {

    init {
        requestRecentMatches()
    }

    private val _uiState = MutableLiveData<MatchListUiData>()
    val uiState: LiveData<MatchListUiData> = _uiState

    private fun requestRecentMatches () {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                useCase.execute()
            }
            _uiState.postValue(maptoUiEvent(response))
        }
    }

    private fun maptoUiEvent (data: List<FeaturedGameInfo>?): MatchListUiData {
        return if (data == null || data.isEmpty()) {
            MatchListUiData.Error("Ha ocurrido un error al recuperar las partidas.")
        } else {
            MatchListUiData.Data(MatchListUiModel(data))
        }
    }

    sealed class MatchListUiData {
        object Loading: MatchListUiData()
        class Data (val data: MatchListUiModel): MatchListUiData()
        class Error (val error: String): MatchListUiData()

    }

    data class MatchListUiModel (
        val gamesList: List<FeaturedGameInfo>
    )
}

class MatchViewModelFactory (private val useCase: GetFeaturedMatchesUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass
            .getConstructor(GetFeaturedMatchesUseCase::class.java)
            .newInstance(useCase)
    }
}