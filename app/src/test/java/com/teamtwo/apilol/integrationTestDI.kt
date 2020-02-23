package com.teamtwo.apilol

import com.example.data.ChampionsLocalDataSource
import com.example.data.ChampionsRemoteDataSource
import com.example.domain.Champion
import com.teamtwo.apilol.di.champions.ChampionsAppModule
import com.teamtwo.apilol.di.champions.ChampionsComponent
import com.teamtwo.apilol.di.champions.ChampionsDataModule
import com.teamtwo.apilol.di.champions.ChampionsUseCaseModule
import com.teamtwo.apilol.model.LOLServiceManager
import com.teamtwo.apilol.ui.champions.detail.ChampionDetailViewModel
import com.teamtwo.apilol.ui.champions.list.ChampionListViewModel
import com.teamtwo.apilol.ui.champions.localChampion
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [
    TestAppModule::class,
    ChampionsDataModule::class,
    ChampionsUseCaseModule::class
])
interface TestComponent : ChampionsComponent {

    val localDataSource: ChampionsLocalDataSource
    val remoteDataSource: ChampionsRemoteDataSource

    @Component.Factory
    interface FactoryTest {
        fun create(): TestComponent
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
}

val defaultFakeChampions = listOf(
    localChampion.copy(id = "id1"),
    localChampion.copy(id = "id2"),
    localChampion.copy(id = "id3"),
    localChampion.copy(id = "id4"),
    localChampion.copy(id = "id5")
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

class FakeChampionsRemoteDataSource : ChampionsRemoteDataSource {

    var champions = defaultFakeChampions

    override suspend fun getChampions(): List<Champion> = champions

}
