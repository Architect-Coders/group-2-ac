package com.teamtwo.apilol.di.champions

import android.app.Application
import androidx.room.Room
import com.example.data.ChampionsLocalDataSource
import com.example.data.ChampionsRemoteDataSource
import com.teamtwo.apilol.model.champions.ChampionsRetrofitDataSource
import com.teamtwo.apilol.model.champions.ChampionsRoomDataSource
import com.teamtwo.apilol.model.database.ApiLolDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ChampionsAppModule {


    @Provides
    @Singleton
    fun databaseProvider(app: Application) = Room.databaseBuilder(
        app,
        ApiLolDatabase::class.java,
        "api_lol_db"
    ).build()

    @Provides
    fun localDataSourceProvider(db: ApiLolDatabase): ChampionsLocalDataSource = ChampionsRoomDataSource(db)

    @Provides
    fun remoteDataSourceProvider(): ChampionsRemoteDataSource = ChampionsRetrofitDataSource()
}