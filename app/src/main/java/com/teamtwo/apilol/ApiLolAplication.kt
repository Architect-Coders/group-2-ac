package com.teamtwo.apilol

import android.app.Application
import androidx.room.Room
import com.teamtwo.apilol.model.database.ApiLolDatabase

class ApiLolAplication : Application() {

    lateinit var db: ApiLolDatabase
        private set

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(
            this,
            ApiLolDatabase::class.java,
            "api_lol_db"
        ).build()
    }
}