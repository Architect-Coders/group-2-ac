package com.teamtwo.apilol.di.items

import android.app.Application
import com.teamtwo.apilol.di.DataSourcesModule
import com.teamtwo.apilol.ui.items.detail.ItemDetailActivityComponent
import com.teamtwo.apilol.ui.items.detail.ItemDetailActivityModule
import com.teamtwo.apilol.ui.items.list.ItemListActivityComponent
import com.teamtwo.apilol.ui.items.list.ItemListActivityModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
    ItemsAppModule::class,
    ItemsDataModule::class,
    ItemsUseCaseModule::class,
    DataSourcesModule::class
])
interface ItemsComponent {

    fun plus(itemListActivityModule: ItemListActivityModule): ItemListActivityComponent
    fun plus(itemDetailActivityModule: ItemDetailActivityModule): ItemDetailActivityComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): ItemsComponent
    }

}