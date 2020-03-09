package com.teamtwo.apilol

import com.teamtwo.apilol.di.spells.DaggerSpellsComponent
import com.teamtwo.apilol.di.spells.SpellsComponent

class UiTestApiLolApplication : ApiLolAplication() {

    override fun initChampionsComponent() = DaggerUiTestComponent.factory().create(this)

    override fun initSpellsComponent() = DaggerSpellsUiTestComponent.factory().create(this)
}