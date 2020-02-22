package com.teamtwo.apilol.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.teamtwo.apilol.model.database.entities.ChampionEntity
import com.teamtwo.apilol.model.database.entities.SpellsEntity
import com.teamtwo.apilol.model.database.entities.MatchesEntity

@Database(entities = [
    ChampionEntity::class,
    SpellsEntity::class,
    MatchesEntity::class
], version = 1)
@TypeConverters(Converters::class)
abstract class ApiLolDatabase : RoomDatabase() {

    abstract fun apiLolDao(): ApilolDAO

}