package com.teamtwo.apilol.di.spells

import com.example.data.SpellsLocalDataSource
import com.example.data.SpellsRemoteDataSource
import com.teamtwo.apilol.model.LOLServiceManager
import com.teamtwo.apilol.model.database.ApiLolDatabase
import com.teamtwo.apilol.model.spells.SpellsRetrofitDatSoruce
import com.teamtwo.apilol.model.spells.SpellsRoomDataSource
import dagger.Module
import dagger.Provides


@Module
class SpellsAppModule {

    @Provides
    fun localDataSoruceProvider(db : ApiLolDatabase): SpellsLocalDataSource = SpellsRoomDataSource(db)

    @Provides
    fun remoteDataSourceProvider(lolServiceManager: LOLServiceManager): SpellsRemoteDataSource
            = SpellsRetrofitDatSoruce(lolServiceManager)
}