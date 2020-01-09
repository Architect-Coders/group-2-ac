package com.teamtwo.apilol.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.teamtwo.apilol.model.database.entities.ChampionEntity

@Database(entities = [ChampionEntity::class], version = 1)
abstract class ApiLolDatabase : RoomDatabase() {

    abstract fun apiLolDao(): ApilolDAO

}