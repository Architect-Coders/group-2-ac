package com.teamtwo.apilol.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.teamtwo.apilol.model.database.entities.ChampionEntity
import com.teamtwo.apilol.model.database.entities.ItemEntity

@Database(entities = [ChampionEntity::class, ItemEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ApiLolDatabase : RoomDatabase() {

    abstract fun apiLolDao(): ApilolDAO
}