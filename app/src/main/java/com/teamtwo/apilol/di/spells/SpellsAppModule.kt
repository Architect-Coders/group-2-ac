package com.teamtwo.apilol.di.spells

import android.app.Application
import androidx.room.Room
import com.example.data.SpellsLocalDataSource
import com.example.data.SpellsRemoteDataSource
import com.teamtwo.apilol.model.database.ApiLolDatabase
import com.teamtwo.apilol.model.spells.SpellsRetrofitDatSoruce
import com.teamtwo.apilol.model.spells.SpellsRoomDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class SpellsAppModule {

    @Provides
    @Singleton
    fun databaseProvider(app: Application) = Room.databaseBuilder(
        app,
        ApiLolDatabase::class.java,
        "api_lol_db"
    ).build()

    @Provides
    fun localDataSoruceProvider(db : ApiLolDatabase): SpellsLocalDataSource = SpellsRoomDataSource(db)

    @Provides
    fun remoteDataSourceProvider(): SpellsRemoteDataSource = SpellsRetrofitDatSoruce()
}