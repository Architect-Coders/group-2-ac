package com.teamtwo.apilol.champions

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.teamtwo.apilol.BaseActivity
import com.teamtwo.apilol.R

class ChampionListActivity : BaseActivity(R.layout.activity_champion_list) {

    private lateinit var viewModel: ChampionListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this,
            ChampionListViewModelFactory(/*championRepository*/)
        )[ChampionListViewModel::class.java]

        viewModel.model.observe(this, Observer(::updateUi))
    }

    override fun initListeners() {
    }

    private fun updateUi(uiModel: ChampionListViewModel.UiModel?) {
        //update ui
    }
}