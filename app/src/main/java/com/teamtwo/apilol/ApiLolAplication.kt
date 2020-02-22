package com.teamtwo.apilol

import android.app.Application
import androidx.room.Room
import com.teamtwo.apilol.di.spells.DaggerSpellsComponent
import com.teamtwo.apilol.di.spells.SpellsComponent
import com.teamtwo.apilol.model.database.ApiLolDatabase
import com.teamtwo.apilol.di.champions.ChampionsComponent
import com.teamtwo.apilol.di.champions.DaggerChampionsComponent
import com.teamtwo.apilol.di.matches.DaggerMatchesComponent
import com.teamtwo.apilol.di.matches.MatchesComponent

class ApiLolAplication : Application() {

    lateinit var championsComponent: ChampionsComponent
        private set

    lateinit var spellsComponent: SpellsComponent
        private set

    lateinit var matchesComponent: MatchesComponent
        private set

    override fun onCreate() {
        super.onCreate()

        spellsComponent = DaggerSpellsComponent.factory().create(this)
        championsComponent = DaggerChampionsComponent.factory().create(this)
        matchesComponent = DaggerMatchesComponent.factory().create(this)
    }
}