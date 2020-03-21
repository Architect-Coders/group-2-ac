package com.teamtwo.apilol

import com.example.data.*
import com.example.domain.Item
import com.teamtwo.apilol.di.items.ItemsComponent
import com.teamtwo.apilol.di.items.ItemsDataModule
import com.teamtwo.apilol.di.items.ItemsUseCaseModule
import com.teamtwo.apilol.ui.items.localItem
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ItemTestAppModule::class,
    ItemsDataModule::class,
    ItemsUseCaseModule::class
])
interface ItemTestComponent : ItemsComponent {

    val localDataSource: LocalDataSourceItems
    val remoteDataSource: RemoteDataSourceItems

    @Component.Factory
    interface FactoryTest {
        fun create(): ItemTestComponent
    }
}

@Module
class ItemTestAppModule {

    @Provides
    @Singleton
    fun itemsLocalDataSourceProvider():
            LocalDataSourceItems = FakeItemsLocalDataSource()

    @Provides
    @Singleton
    fun itemsRemoteDataSourceProvider():
            RemoteDataSourceItems = FakeItemsRemoteDataSource()

    @Provides
    @Singleton
    fun itemsLocationDataSourceProvider():
            LocationDataSource = FakeItemsLocationDataSource()

    @Provides
    @Singleton
    fun itemsPermissionChecker():
            PermissionChecker = FakeItemsPermisionChecker()
}

val defaultFakeItems = listOf(
    localItem.copy(id = 1),
    localItem.copy(id = 2),
    localItem.copy(id = 3),
    localItem.copy(id = 4),
    localItem.copy(id = 5)
)

class FakeItemsLocalDataSource : LocalDataSourceItems {

    var items = emptyList<Item>()

    override suspend fun itemsExists(): Boolean = items.isEmpty()

    override suspend fun saveItems(items: List<Item>) {
        this.items = items
    }

    override suspend fun getItems(): List<Item> = items

    override suspend fun updateItem(item: Item) {
        items = items.filterNot { it.id == item.id } + item
    }

    override suspend fun findItemById(itemId: String): Item
            = items.first { it.id.toString() == itemId }
}

class FakeItemsRemoteDataSource : RemoteDataSourceItems {

    var items = defaultFakeItems

    override suspend fun getItems(region: String): List<Item> = items

}

class FakeItemsLocationDataSource : LocationDataSource {

    override suspend fun findLastRegion(): String? = "ES"

}

class FakeItemsPermisionChecker : PermissionChecker {

    override suspend fun check(permission: PermissionChecker.Permission): Boolean = true
}
