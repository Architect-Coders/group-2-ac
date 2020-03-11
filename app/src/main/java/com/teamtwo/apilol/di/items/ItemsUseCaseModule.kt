package com.teamtwo.apilol.di.items

import com.example.data.ItemsRepository
import com.example.usecases.GetItem
import com.example.usecases.GetItems
import dagger.Module
import dagger.Provides

@Module
class ItemsUseCaseModule {

    @Provides
    fun getItemProvider(itemsRepository: ItemsRepository)
            = GetItem(itemsRepository)

    @Provides
    fun getGetItemsProvider(itemsRepository: ItemsRepository)
            = GetItems(itemsRepository)

}