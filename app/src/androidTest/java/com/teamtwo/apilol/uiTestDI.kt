package com.teamtwo.apilol

import android.app.Application
import androidx.room.Room
import com.teamtwo.apilol.di.DataSourcesModule
import com.teamtwo.apilol.di.champions.ChampionsAppModule
import com.teamtwo.apilol.di.champions.ChampionsComponent
import com.teamtwo.apilol.di.champions.ChampionsDataModule
import com.teamtwo.apilol.di.champions.ChampionsUseCaseModule
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
