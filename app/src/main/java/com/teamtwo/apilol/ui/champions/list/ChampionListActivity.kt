package com.teamtwo.apilol.ui.champions.list

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.teamtwo.apilol.ApiLolAplication
import com.teamtwo.apilol.R
import com.teamtwo.apilol.ui.base.BaseActivity
import com.teamtwo.apilol.ui.champions.list.ChampionListViewModel.UiModel
import com.teamtwo.apilol.ui.champions.detail.ChampionDetailActivity
import com.teamtwo.apilol.ui.champions.detail.ChampionDetailActivityModule
import kotlinx.android.synthetic.main.activity_champion_list.*
import kotlinx.android.synthetic.main.loading.*

class ChampionListActivity : BaseActivity(R.layout.activity_champion_list) {

    /*
    private val viewModel by lazy {
        ViewModelProvider(
            this,
            ChampionListViewModelFactory(
                GetChampions(
                    ChampionsRepository(
                        ChampionsRoomDataSource((application as ApiLolAplication).db),
                        ChampionsRetrofitDataSource()
                    )
                )
            )
        ).get(ChampionListViewModel::class.java)
    }
     */

    private lateinit var component: ChampionListActivityComponent
    private val viewModel by lazy { component.viewModel }

    private lateinit var adapter: ChampionsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        component = (application as ApiLolAplication).championsComponent.plus(ChampionListActivityModule())

        supportActionBar?.title = "Champions"

        rvChampions.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        adapter =
            ChampionsAdapter(viewModel::onChampionClicked)
        rvChampions.adapter = adapter

        viewModel.model.observe(this, Observer(::updateUi))
    }

    override fun onResume() {
        super.onResume()
        viewModel.refresh()
    }

    override fun initListeners() {}

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
                        .putExtra(ChampionDetailActivity::class.java.canonicalName, uiModel.champion.id)
                )
        }
    }
}