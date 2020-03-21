package com.teamtwo.apilol

import android.app.Application
import androidx.room.Room
import com.teamtwo.apilol.di.champions.ChampionsAppModule
import com.teamtwo.apilol.di.champions.ChampionsComponent
import com.teamtwo.apilol.di.champions.ChampionsDataModule
import com.teamtwo.apilol.di.champions.ChampionsUseCaseModule
import com.teamtwo.apilol.di.items.ItemsAppModule
import com.teamtwo.apilol.di.items.ItemsComponent
import com.teamtwo.apilol.di.items.ItemsDataModule
import com.teamtwo.apilol.di.items.ItemsUseCaseModule
import com.teamtwo.apilol.di.matches.MatchesAppModule
import com.teamtwo.apilol.di.matches.MatchesComponent
import com.teamtwo.apilol.di.matches.MatchesDataModule
import com.teamtwo.apilol.di.matches.MatchesUseCaseModule
import com.teamtwo.apilol.di.spells.SpellsAppModule
import com.teamtwo.apilol.di.spells.SpellsComponent
import com.teamtwo.apilol.di.spells.SpellsDataModule
import com.teamtwo.apilol.di.spells.SpellsUseCaseModule
import com.teamtwo.apilol.model.LOLServiceManager
import com.teamtwo.apilol.model.database.ApiLolDatabase
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.mockwebserver.MockWebServer
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ChampionsAppModule::class,
    ChampionsDataModule::class,
    ChampionsUseCaseModule::class,
    UiTestServerModule::class
])
interface UiTestComponent : ChampionsComponent {

    val lolServiceManager: LOLServiceManager
    val mockWebServer: MockWebServer

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): UiTestComponent
    }

}

@Singleton
@Component(modules = [
    ItemsAppModule::class,
    ItemsDataModule::class,
    ItemsUseCaseModule::class,
    UiTestServerModule::class
])
interface ItemsUiTestComponent : ItemsComponent {

    val lolServiceManager: LOLServiceManager
    val mockWebServer: MockWebServer

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): ItemsUiTestComponent
    }

}

@Singleton
@Component(modules = [
    SpellsAppModule::class,
    SpellsDataModule::class,
    SpellsUseCaseModule::class,
    UiTestServerModule::class
])
interface SpellsUiTestComponent : SpellsComponent {

    val lolServiceManager: LOLServiceManager
    val mockWebServer: MockWebServer

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): SpellsUiTestComponent
    }

}

@Singleton
@Component(modules = [
    MatchesAppModule::class,
    MatchesDataModule::class,
    MatchesUseCaseModule::class,
    UiTestServerModule::class
])
interface MatchesUiTestComponent : MatchesComponent {

    val lolServiceManager: LOLServiceManager
    val mockWebServer: MockWebServer

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): MatchesUiTestComponent
    }

}

@Module
class UiTestServerModule {

    @Provides @Singleton
    fun databaseProvider(app: Application): ApiLolDatabase = Room.inMemoryDatabaseBuilder(
        app,
        ApiLolDatabase::class.java
    )
        .allowMainThreadQueries()
        .build()


    @Provides
    @Singleton
    @Named("baseUrl")
    fun baseUrlProvider(): String = "http://127.0.0.1:8080"

    @Provides
    @Singleton
    @Named("apiUrl")
    fun apiUrlProvider(): String = "http://127.0.0.1:8080"

    @Provides
    @Singleton
    fun mockWebServerProvider(): MockWebServer {
        var mockWebServer:MockWebServer? = null
        val thread = Thread(Runnable {
            mockWebServer = MockWebServer()
            mockWebServer?.start(8080)
        })
        thread.start()
        thread.join()
        return mockWebServer ?: throw NullPointerException()
    }

    @Provides
    @Singleton
    fun lolServiceManagerProvider(@Named("baseUrl") baseUrl: String,
                                  @Named("apiUrl") apiUrl: String): LOLServiceManager
            = LOLServiceManager(baseUrl, apiUrl)
}
