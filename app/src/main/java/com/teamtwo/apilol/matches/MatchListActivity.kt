package com.teamtwo.apilol.matches

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.teamtwo.apilol.BaseActivity
import com.teamtwo.apilol.R
import com.teamtwo.apilol.model.LOLServiceManager
import com.teamtwo.apilol.toast
import kotlinx.android.synthetic.main.activity_match_list.*

class MatchListActivity: BaseActivity(R.layout.activity_match_list) {

    private val viewModel: MatchViewModel by lazy {

        ViewModelProviders.of(this,
            MatchViewModelFactory(GetFeaturedMatchesUseCase(LOLServiceManager().apiService))
        ).get(MatchViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MatchListActivity, LinearLayoutManager.VERTICAL, false)
            adapter = MatchListAdapter {
                startActivity(Intent(this@MatchListActivity, MatchDetailActivity::class.java).apply {
                    putExtra("match", it)
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