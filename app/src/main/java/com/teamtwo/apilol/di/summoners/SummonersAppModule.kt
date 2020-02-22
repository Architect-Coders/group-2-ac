package com.teamtwo.apilol.di.summoners

import android.app.Application
import androidx.room.Room
import com.example.data.RemoteSummonerDataSource
import com.teamtwo.apilol.BuildConfig
import com.teamtwo.apilol.model.database.ApiLolDatabase
import com.teamtwo.apilol.model.sumonners.SummonersRetrofitDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SummonersAppModule {

    @Provides @Singleton
    fun databaseProvider(app: Application) = Room.databaseBuilder(
        app,
        ApiLolDatabase::class.java,
        "api_lol_db"
    ).build()

    @Provides
    fun remoteDataSourceProvider(): RemoteSummonerDataSource = SummonersRetrofitDataSource(BuildConfig.API_KEY)

}