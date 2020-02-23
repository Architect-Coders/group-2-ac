package com.teamtwo.apilol.ui.matches

import com.example.usecases.GetMatches
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class MatchesListActivityModule {

    @Provides
    fun matchesListViewModelProvider(getMatches: GetMatches)
            = MatchViewModel(getMatches)

}

@Subcomponent(modules = [(MatchesListActivityModule::class)])
interface MatchesListActivityComponent {
    val viewModel: MatchViewModel
}