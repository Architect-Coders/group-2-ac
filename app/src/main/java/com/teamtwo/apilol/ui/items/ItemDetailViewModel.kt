package com.teamtwo.apilol.ui.items

import androidx.lifecycle.*
import com.example.domain.Item
import com.example.usecases.GetItem
import kotlinx.coroutines.launch

class ItemDetailViewModel(
    private val itemId: String,
    private val getItem: GetItem): ViewModel() {

    private val _item = MutableLiveData<Item>()
    val item: LiveData<Item>
        get() {
            if (_item.value == null) findItemById(itemId)
            return _item
        }

    private fun findItemById(itemId: String) = viewModelScope.launch {
        _item.value = getItem.invoke(itemId)
    }
}
class ItemDetailViewModelFactory(
    private val itemId: String,
    private val getItem: GetItem) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
            = ItemDetailViewModel(itemId, getItem) as T
}