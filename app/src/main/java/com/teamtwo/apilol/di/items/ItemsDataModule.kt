package com.teamtwo.apilol.di.items

import com.example.data.LocalDataSourceItems
import com.example.data.RemoteDataSourceItems
import com.example.data.ItemsRepository
import com.example.data.RegionRepository
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

}