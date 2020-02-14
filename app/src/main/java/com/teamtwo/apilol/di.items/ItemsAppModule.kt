package com.teamtwo.apilol.di.items

import android.app.Application
import androidx.room.Room
import com.example.data.LocalDataSourceItems
import com.example.data.RemoteDataSourceItems
import com.teamtwo.apilol.model.database.ApiLolDatabase
import com.teamtwo.apilol.model.items.RetrofitDataSource
import com.teamtwo.apilol.model.items.RoomDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ItemsAppModule {


    @Provides
    @Singleton
    fun databaseProvider(app: Application) = Room.databaseBuilder(
        app,
        ApiLolDatabase::class.java,
        "api_lol_db"
    ).build()

    @Provides
    fun localDataSourceProvider(db: ApiLolDatabase): LocalDataSourceItems = RoomDataSource(db)

    @Provides
    fun remoteDataSourceProvider(): RemoteDataSourceItems = RetrofitDataSource()
}