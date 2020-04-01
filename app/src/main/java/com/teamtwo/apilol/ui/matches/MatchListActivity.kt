package com.teamtwo.apilol.ui.matches

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.teamtwo.apilol.ApiLolAplication
import com.teamtwo.apilol.ui.base.BaseActivity
import com.teamtwo.apilol.R
import com.teamtwo.apilol.getViewModel
import com.teamtwo.apilol.toast
import kotlinx.android.synthetic.main.activity_match_list.*

@kotlin.time.ExperimentalTime
class MatchListActivity: BaseActivity(R.layout.activity_match_list) {

    private lateinit var component: MatchesListActivityComponent
    private val viewModel by lazy { getViewModel { component.viewModel } }

    override fun onCreate(savedInstanceState: Bundle?) {
        component = (application as ApiLolAplication).matchesComponent.plus(MatchesListActivityModule())
        super.onCreate(savedInstanceState)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MatchListActivity, LinearLayoutManager.VERTICAL, false)
            adapter = MatchListAdapter {
                startActivity(Intent(this@MatchListActivity, MatchDetailActivity::class.java).apply {
                    putExtra("match", Gson().toJson(it))
                })
            }
        }

        viewModel.requestRecentMatches()
    }

    override fun initListeners() {

        viewModel.uiState.observe(this, Observer (::manageState))
    }

    private fun manageState (uiState: MatchViewModel.MatchListUiData) {
        when (uiState) {
            is MatchViewModel.MatchListUiData.Loading -> {}
            is MatchViewModel.MatchListUiData.Error -> {
                toast(uiState.error)
                (recyclerView?.adapter as MatchListAdapter).setData(emptyList(), uiState.oldMatches)

            }
            is MatchViewModel.MatchListUiData.Data -> {
                (recyclerView?.adapter as MatchListAdapter).setData(uiState.data.recentMatches, uiState.data.oldMatches)
            }
        }
    }
}