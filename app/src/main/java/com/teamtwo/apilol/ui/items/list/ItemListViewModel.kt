package com.teamtwo.apilol.ui.items.list

import androidx.lifecycle.*
import com.example.domain.Item
import com.example.usecases.GetItems
import kotlinx.coroutines.launch

class ItemListViewModel(private val getItems: GetItems)
    : ViewModel() {

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val items: List<Item>): UiModel()
        class Navigation(val item: Item): UiModel()
    }

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel> = _model

    fun refresh(){
        viewModelScope.launch {
            _model.value =
                UiModel.Loading
            _model.value =
                UiModel.Content(
                    getItems.invoke()
                )
        }
    }

    fun onItemClicked(item: Item){
        _model.value =
            UiModel.Navigation(
                item
            )
    }
}

class ItemListViewModelFactory(private val getItems: GetItems) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = ItemListViewModel(getItems) as T
}