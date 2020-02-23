package com.teamtwo.apilol.ui.items.detail

import com.example.usecases.GetItem
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class ItemDetailActivityModule(private val itemId: String) {

    @Provides
    fun itemDetailViewModelProvider(
        getItem: GetItem
    ) = ItemDetailViewModel(
        itemId,
        getItem
    )

}

@Subcomponent(modules = [(ItemDetailActivityModule::class)])
interface ItemDetailActivityComponent {
    val itemDetailViewModel: ItemDetailViewModel
}

