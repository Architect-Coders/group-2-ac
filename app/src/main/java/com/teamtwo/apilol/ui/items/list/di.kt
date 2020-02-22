package com.teamtwo.apilol.ui.items.list

import com.example.usecases.GetItems
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class ItemListActivityModule {

    @Provides
    fun itemListViewModelProvider(getItems: GetItems)
            = ItemListViewModel(getItems)
    
}

@Subcomponent(modules = [(ItemListActivityModule::class)])
interface ItemListActivityComponent {
    val viewModel: ItemListViewModel
}