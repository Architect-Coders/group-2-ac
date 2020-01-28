package com.teamtwo.apilol.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.teamtwo.apilol.model.database.entities.ChampionEntity
import com.teamtwo.apilol.model.database.entities.items.GoldEntity
import com.teamtwo.apilol.model.database.entities.items.ImageEntity
import com.teamtwo.apilol.model.database.entities.items.ItemEntity

@Database(entities = [ChampionEntity::class,ItemEntity::class,ImageEntity::class,GoldEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class ApiLolDatabase : RoomDatabase() {

    abstract fun apiLolDao(): ApilolDAO
    abstract fun itemDAO(): ItemDAO

}