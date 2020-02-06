package com.teamtwo.apilol.ui.matches

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data.MatchesRepository
import com.example.usecases.GetMatches
import com.google.gson.Gson
import com.teamtwo.apilol.ApiLolAplication
import com.teamtwo.apilol.ui.base.BaseActivity
import com.teamtwo.apilol.R
import com.teamtwo.apilol.model.LOLServiceManager
import com.teamtwo.apilol.model.champions.RetrofitDataSource
import com.teamtwo.apilol.model.champions.RoomDataSource
import com.teamtwo.apilol.toast
import kotlinx.android.synthetic.main.activity_match_list.*

@kotlin.time.ExperimentalTime
class MatchListActivity: BaseActivity(R.layout.activity_match_list) {

    private val viewModel: MatchViewModel by lazy {

        ViewModelProviders.of(this,
            MatchViewModelFactory(
                GetMatches(MatchesRepository(
                    RoomDataSource((application as ApiLolAplication).db),
                    RetrofitDataSource()
                ))
            )
        ).get(MatchViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MatchListActivity, LinearLayoutManager.VERTICAL, false)
            adapter = MatchListAdapter {
                startActivity(Intent(this@MatchListActivity, MatchDetailActivity::class.java).apply {
                    putExtra("match", Gson().toJson(it))
                })
            }
        }
    }

    override fun initListeners() {

        viewModel.uiState.observe(this, Observer (::manageState))
    }

    private fun manageState (uiState: MatchViewModel.MatchListUiData) {
        when (uiState) {
            is MatchViewModel.MatchListUiData.Loading -> {}
            is MatchViewModel.MatchListUiData.Error -> toast(uiState.error)
            is MatchViewModel.MatchListUiData.Data -> {
                (recyclerView?.adapter as MatchListAdapter).submitList(uiState.data.gamesList)
            }
        }
    }
}