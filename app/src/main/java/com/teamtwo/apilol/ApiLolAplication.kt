package com.teamtwo.apilol

import android.app.Application
import com.teamtwo.apilol.di.champions.ChampionsComponent
import com.teamtwo.apilol.di.champions.DaggerChampionsComponent
import com.teamtwo.apilol.di.items.DaggerItemsComponent
import com.teamtwo.apilol.di.items.ItemsComponent

class ApiLolAplication : Application() {

    lateinit var championsComponent: ChampionsComponent
        private set
    lateinit var itemsComponent: ItemsComponent
        private set

    override fun onCreate() {
        super.onCreate()

        championsComponent = DaggerChampionsComponent.factory().create(this)
        itemsComponent = DaggerItemsComponent.factory().create(this)
    }
}