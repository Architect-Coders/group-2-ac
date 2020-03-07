package com.teamtwo.apilol

import com.teamtwo.apilol.di.matches.MatchesComponent

class UiTestApiLolApplication : ApiLolAplication() {

    override fun initChampionsComponent() = DaggerUiTestComponent.factory().create(this)

    override fun initMatchesComponent() = DaggerMatchesUiTestComponent.factory().create(this)

}