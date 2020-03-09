package com.teamtwo.apilol

class UiTestApiLolApplication : ApiLolAplication() {

    override fun initChampionsComponent() = DaggerUiTestComponent.factory().create(this)
    override fun initItemsComponent() = DaggerUiTestComponent.factory().create(this)

}