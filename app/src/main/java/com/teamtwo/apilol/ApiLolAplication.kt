package com.teamtwo.apilol

import android.app.Application
import com.teamtwo.apilol.di.champions.ChampionsComponent
import com.teamtwo.apilol.di.champions.DaggerChampionsComponent
import com.teamtwo.apilol.di.matches.DaggerMatchesComponent
import com.teamtwo.apilol.di.matches.MatchesComponent

class ApiLolAplication : Application() {

    lateinit var championsComponent: ChampionsComponent
        private set

    lateinit var matchesComponent: MatchesComponent
        private set

    override fun onCreate() {
        super.onCreate()

        championsComponent = DaggerChampionsComponent.factory().create(this)
        matchesComponent = DaggerMatchesComponent.factory().create(this)
    }
}