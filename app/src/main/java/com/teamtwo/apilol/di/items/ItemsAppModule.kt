package com.teamtwo.apilol.di.items

import android.app.Application
import com.example.data.*
import com.teamtwo.apilol.AndroidPermissionChecker
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

    @Provides
    fun locationDataSourceProvider(app: Application): LocationDataSource =
        PlayServicesLocationDataSource(app)

    @Provides
    fun permissionCheckerProvider(app: Application): PermissionChecker =
        AndroidPermissionChecker(app)
}