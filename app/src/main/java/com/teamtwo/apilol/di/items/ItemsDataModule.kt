package com.teamtwo.apilol.di.items

import com.example.data.*
import dagger.Module
import dagger.Provides

@Module
class ItemsDataModule {

    @Provides
    fun itemsRepositoryProvider(
        localDataSource: LocalDataSourceItems,
        remoteDataSource: RemoteDataSourceItems,
        regionRepository: RegionRepository
    ) = ItemsRepository(localDataSource, remoteDataSource,regionRepository)

    @Provides
    fun regionRepositoryProvider(
        locationDataSource: LocationDataSource,
        permissionChecker: PermissionChecker
    ) = RegionRepository(locationDataSource, permissionChecker)
}