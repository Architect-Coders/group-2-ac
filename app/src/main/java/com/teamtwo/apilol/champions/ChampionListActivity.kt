package com.teamtwo.apilol.champions

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.teamtwo.apilol.BaseActivity
import com.teamtwo.apilol.R
import com.teamtwo.apilol.model.ChampionsRepository
import com.teamtwo.apilol.champions.ChampionListViewModel.UiModel
import com.teamtwo.apilol.toast
import kotlinx.android.synthetic.main.activity_champion_list.*
import kotlinx.android.synthetic.main.loading.*

class ChampionListActivity : BaseActivity(R.layout.activity_champion_list) {

    private lateinit var viewModel: ChampionListViewModel
    private lateinit var adapter: ChampionsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Champions"

        viewModel = ViewModelProviders.of(this,
            ChampionListViewModelFactory(ChampionsRepository())
        )[ChampionListViewModel::class.java]

        rvChampions.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        adapter = ChampionsAdapter(viewModel::onMovieClicked)
        rvChampions.adapter = adapter

        viewModel.model.observe(this, Observer(::updateUi))
    }

    override fun initListeners() {
    }

    private fun updateUi(uiModel: UiModel) {

        loading.visibility = if (uiModel is UiModel.Loading) View.VISIBLE else View.GONE

        when (uiModel){
            is UiModel.Content -> {
                adapter.championList = uiModel.champions
                adapter.notifyDataSetChanged()
            }
            is UiModel.Navigation ->
                startActivity(
                    Intent(this, ChampionDetailActivity::class.java)
                        .putExtra(ChampionDetailActivity::class.java.canonicalName, uiModel.champion)
                )
        }
    }
}