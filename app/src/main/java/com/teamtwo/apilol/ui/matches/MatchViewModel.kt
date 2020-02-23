package com.teamtwo.apilol.ui.matches

import androidx.lifecycle.*
import com.example.domain.FeaturedGameInfo
import com.example.usecases.GetMatches
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MatchViewModel (private val useCase: GetMatches): ViewModel() {

    private val _uiState = MutableLiveData<MatchListUiData>()
    val uiState: LiveData<MatchListUiData> = _uiState

    fun requestRecentMatches () {
        _uiState.value = MatchListUiData.Loading()

        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                useCase.invoke()
            }
            _uiState.value = mapToUiEvent(response.first, response.second)
        }
    }

    private fun mapToUiEvent (recentData: List<FeaturedGameInfo>, oldData: List<FeaturedGameInfo>): MatchListUiData {
        return if (recentData.isEmpty()) {
            MatchListUiData.Error("Ha ocurrido un error al recuperar las partidas.", oldData)
        } else {
            MatchListUiData.Data(MatchListUiModel(recentData, oldData))
        }
    }

    sealed class MatchListUiData {
        data class Loading (val loading: String = "loading"): MatchListUiData()
        data class Data (val data: MatchListUiModel): MatchListUiData()
        data class Error (val error: String, val oldMatches: List<FeaturedGameInfo>): MatchListUiData()

    }

    data class MatchListUiModel (
        val recentMatches: List<FeaturedGameInfo>,
        val oldMatches: List<FeaturedGameInfo>
    )
}

class MatchViewModelFactory (private val useCase: GetMatches): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass
            .getConstructor(GetMatches::class.java)
            .newInstance(useCase)
    }
}