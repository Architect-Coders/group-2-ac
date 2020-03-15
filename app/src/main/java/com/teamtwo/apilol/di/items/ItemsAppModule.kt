package com.teamtwo.apilol.di.items

import com.example.data.LocalDataSourceItems
import com.example.data.LocationDataSource
import com.example.data.RemoteDataSourceItems
import com.teamtwo.apilol.PlayServicesLocationDataSource
import com.teamtwo.apilol.model.LOLServiceManager
import com.teamtwo.apilol.model.database.ApiLolDatabase
import com.teamtwo.apilol.model.items.RetrofitDataSource
import com.teamtwo.apilol.model.items.RoomDataSource
import dagger.Module
import dagger.Provides

@Module
class ItemsAppModule {

    @Provides
    fun localDataSourceProvider(db: ApiLolDatabase): LocalDataSourceItems = RoomDataSource(db)

    @Provides
    fun remoteDataSourceProvider(lolServiceManager: LOLServiceManager): RemoteDataSourceItems
            = RetrofitDataSource(lolServiceManager)
}