package com.teamtwo.apilol.ui.items

import androidx.lifecycle.*
import com.teamtwo.apilol.model.ItemsRepository
import com.teamtwo.apilol.model.items.Item
import kotlinx.coroutines.launch

class ItemListViewModel(private val itemsRepository: ItemsRepository)
    : ViewModel() {

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val items: List<Item>): UiModel()
        class Navigation(val item: Item): UiModel()
    }

    private val _model = MutableLiveData<UiModel>()

    val model: LiveData<UiModel>
        get() {
        if (_model.value == null) refresh()
        return _model
    }

    private fun refresh(){
        viewModelScope.launch {
            _model.value = UiModel.Loading
            val itemsResponse = itemsRepository.getItems()
            val itemList = itemsResponse.body()?.data?.values?.toList()
            _model.value = UiModel.Content(itemList ?: emptyList())
        }
    }

    fun onItemClicked(item: Item){
        _model.value = UiModel.Navigation(item)
    }
}

class ItemListViewModelFactory(private val repository: ItemsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = ItemListViewModel(repository) as T
}