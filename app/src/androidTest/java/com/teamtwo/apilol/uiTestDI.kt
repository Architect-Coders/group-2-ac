package com.teamtwo.apilol

import android.app.Application
import com.example.data.ChampionsLocalDataSource
import com.example.data.ChampionsRemoteDataSource
import com.teamtwo.apilol.di.ServerModule
import com.teamtwo.apilol.di.champions.ChampionsAppModule
import com.teamtwo.apilol.di.champions.ChampionsComponent
import com.teamtwo.apilol.di.champions.ChampionsDataModule
import com.teamtwo.apilol.di.champions.ChampionsUseCaseModule
import com.teamtwo.apilol.model.LOLServiceManager
import com.teamtwo.apilol.ui.champions.detail.ChampionDetailActivityComponent
import com.teamtwo.apilol.ui.champions.detail.ChampionDetailActivityModule
import com.teamtwo.apilol.ui.champions.list.ChampionListActivityComponent
import com.teamtwo.apilol.ui.champions.list.ChampionListActivityModule
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