package com.teamtwo.apilol.di.matches

import android.app.Application
import androidx.room.Room
import com.example.data.MatchesLocalDataSource
import com.example.data.MatchesRemoteDataSource
import com.teamtwo.apilol.BuildConfig
import com.teamtwo.apilol.model.database.ApiLolDatabase
import com.teamtwo.apilol.model.matches.MatchesRetrofitDataSource
import com.teamtwo.apilol.model.matches.MatchesRoomDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MatchesAppModule {

    @Provides @Singleton
    fun databaseProvider(app: Application) = Room.databaseBuilder(
        app,
        ApiLolDatabase::class.java,
        "api_lol_db"
    ).build()

    @Provides
    fun localDataSourceProvider(db: ApiLolDatabase): MatchesLocalDataSource = MatchesRoomDataSource(db)

    @Provides
    fun remoteDataSourceProvider(): MatchesRemoteDataSource = MatchesRetrofitDataSource(BuildConfig.API_KEY)

}