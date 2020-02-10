package com.teamtwo.apilol

import android.app.Application
import androidx.room.Room
import com.teamtwo.apilol.di.spells.DaggerSpellsComponent
import com.teamtwo.apilol.di.spells.SpellsComponent
import com.teamtwo.apilol.model.database.ApiLolDatabase

class ApiLolAplication : Application() {

    lateinit var spellsComponent: SpellsComponent
        private set

    lateinit var db: ApiLolDatabase
        private set

    override fun onCreate() {
        super.onCreate()

        spellsComponent = DaggerSpellsComponent.factory().create(this)

    }
}