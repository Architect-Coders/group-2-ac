package com.teamtwo.apilol

import com.example.data.ChampionsLocalDataSource
import com.example.data.ChampionsRemoteDataSource
import com.example.data.LocalDataSourceItems
import com.example.data.RemoteDataSourceItems
import com.example.domain.Champion
import com.example.domain.Item
import com.teamtwo.apilol.di.champions.ChampionsComponent
import com.teamtwo.apilol.di.champions.ChampionsDataModule
import com.teamtwo.apilol.di.champions.ChampionsUseCaseModule
import com.teamtwo.apilol.di.items.ItemsComponent
import com.teamtwo.apilol.di.items.ItemsDataModule
import com.teamtwo.apilol.di.items.ItemsUseCaseModule
import com.teamtwo.apilol.ui.champions.localChampion
import com.teamtwo.apilol.ui.items.localItem
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [
    TestAppModule::class,
    ChampionsDataModule::class,
    ChampionsUseCaseModule::class,
    ItemsDataModule::class,
    ItemsUseCaseModule::class
])
interface TestComponent : ChampionsComponent {

    val localDataSource: ChampionsLocalDataSource
    val remoteDataSource: ChampionsRemoteDataSource

    @Component.Factory
    interface FactoryTest {
        fun create(): TestComponent
    }
}

interface ItemTestComponent : ItemsComponent {

    val localDataSource: LocalDataSourceItems
    val remoteDataSource: RemoteDataSourceItems

    @Component.Factory
    interface FactoryTest {
        fun create(): ItemTestComponent
    }
}

@Module
class TestAppModule {

    @Provides
    @Singleton
    fun championsLocalDataSourceProvider():
            ChampionsLocalDataSource = FakeChampionsLocalDataSource()

    @Provides
    @Singleton
    fun championsRemoteDataSourceProvider():
            ChampionsRemoteDataSource = FakeChampionsRemoteDataSource()

    @Provides
    @Singleton
    fun itemsLocalDataSourceProvider():
            LocalDataSourceItems = FakeItemsLocalDataSource()

    @Provides
    @Singleton
    fun itemsRemoteDataSourceProvider():
            RemoteDataSourceItems = FakeItemsRemoteDataSource()
}

val defaultFakeChampions = listOf(
    localChampion.copy(id = "id1"),
    localChampion.copy(id = "id2"),
    localChampion.copy(id = "id3"),
    localChampion.copy(id = "id4"),
    localChampion.copy(id = "id5")
)

val defaultFakeItems = listOf(
    localItem.copy(id = 1),
    localItem.copy(id = 2),
    localItem.copy(id = 3),
    localItem.copy(id = 4),
    localItem.copy(id = 5)
)

class FakeChampionsLocalDataSource : ChampionsLocalDataSource {

    var champions = emptyList<Champion>()

    override suspend fun areChampionsEmpty(): Boolean = champions.isEmpty()

    override suspend fun saveChampions(champions: List<Champion>) {
        this.champions = champions
    }

    override suspend fun getChampions(): List<Champion> = champions

    override suspend fun updateChampion(champion: Champion) {
        champions = champions.filterNot { it.id == champion.id } + champion
    }

    override suspend fun findChampionById(championId: String): Champion
            = champions.first { it.id == championId }
}

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

class FakeChampionsRemoteDataSource : ChampionsRemoteDataSource {

    var champions = defaultFakeChampions

    override suspend fun getChampions(): List<Champion> = champions

}

class FakeItemsRemoteDataSource : RemoteDataSourceItems {

    var items = defaultFakeItems

    override suspend fun getItems(region: String): List<Item> = items

}
