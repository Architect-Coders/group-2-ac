package com.teamtwo.apilol

import android.app.Application
import androidx.room.Room
import com.teamtwo.apilol.di.champions.ChampionsComponent
import com.teamtwo.apilol.di.champions.DaggerChampionsComponent
import com.teamtwo.apilol.model.database.ApiLolDatabase

class ApiLolAplication : Application() {

    lateinit var championsComponent: ChampionsComponent
        private set

    override fun onCreate() {
        super.onCreate()

        championsComponent = DaggerChampionsComponent.factory().create(this)
    }
}