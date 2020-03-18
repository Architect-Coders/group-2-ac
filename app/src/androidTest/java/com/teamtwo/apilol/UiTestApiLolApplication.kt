package com.teamtwo.apilol

import com.teamtwo.apilol.di.items.ItemsComponent

class UiTestApiLolApplication : ApiLolAplication() {

    override fun initChampionsComponent() = DaggerUiTestComponent.factory().create(this)
    override fun initItemsComponent() = DaggerItemsUiTestComponent.factory().create(this)
    override fun initSpellsComponent() = DaggerSpellsUiTestComponent.factory().create(this)
    override fun initMatchesComponent() = DaggerMatchesUiTestComponent.factory().create(this)

}