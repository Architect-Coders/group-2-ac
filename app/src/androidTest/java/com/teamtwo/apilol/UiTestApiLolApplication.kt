package com.teamtwo.apilol

class UiTestApiLolApplication : ApiLolAplication() {

    override fun initChampionsComponent() = DaggerUiTestComponent.factory().create(this)
    override fun initSpellsComponent() = DaggerSpellsUiTestComponent.factory().create(this)
    override fun initMatchesComponent() = DaggerMatchesUiTestComponent.factory().create(this)

}