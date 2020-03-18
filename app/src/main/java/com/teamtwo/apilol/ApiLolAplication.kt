package com.teamtwo.apilol

import android.app.Application
import com.teamtwo.apilol.di.champions.ChampionsComponent
import com.teamtwo.apilol.di.champions.DaggerChampionsComponent
import com.teamtwo.apilol.di.items.DaggerItemsComponent
import com.teamtwo.apilol.di.items.ItemsComponent
import com.teamtwo.apilol.di.matches.DaggerMatchesComponent
import com.teamtwo.apilol.di.matches.MatchesComponent
import com.teamtwo.apilol.di.spells.DaggerSpellsComponent
import com.teamtwo.apilol.di.spells.SpellsComponent
import com.teamtwo.apilol.di.summoners.DaggerSummonersComponent
import com.teamtwo.apilol.di.summoners.SummonersComponent

open class ApiLolAplication : Application() {

    lateinit var championsComponent: ChampionsComponent
        private set

    lateinit var itemsComponent: ItemsComponent
        private set

    lateinit var spellsComponent: SpellsComponent
        private set

    lateinit var matchesComponent: MatchesComponent
        private set

    lateinit var summonerComponent: SummonersComponent
        private set

    override fun onCreate() {
        super.onCreate()

        spellsComponent = DaggerSpellsComponent.factory().create(this)
        championsComponent = initChampionsComponent()
        matchesComponent = initMatchesComponent()
        itemsComponent = DaggerItemsComponent.factory().create(this)
        summonerComponent = initSummonerComponent()
    }

    open fun initChampionsComponent() = DaggerChampionsComponent.factory().create(this)
    open fun initSummonerComponent() = DaggerSummonersComponent.factory().create(this)
    open fun initSpellsComponent() = DaggerSpellsComponent.factory().create(this)
    open fun initMatchesComponent() = DaggerMatchesComponent.factory().create(this)
}