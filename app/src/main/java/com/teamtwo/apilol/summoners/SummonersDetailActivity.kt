package com.teamtwo.apilol.summoners

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.teamtwo.apilol.BaseActivity
import com.teamtwo.apilol.R
import com.teamtwo.apilol.model.ChampionsRepository
import com.teamtwo.apilol.summoners.SummonnerViewModel.UiModelSummoner
import com.teamtwo.apilol.model.SummonerRepository
import com.teamtwo.apilol.model.sumonners.Summoner
import com.teamtwo.apilol.toast
import kotlinx.android.synthetic.main.activity_champion_list.*
import kotlinx.android.synthetic.main.activity_summoner_detail.*
import kotlinx.android.synthetic.main.loading.*

class SummonersDetailActivity : BaseActivity(R.layout.activity_summoner_detail) {

    private lateinit var viewModel: SummonnerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Summoner"

        viewModel = ViewModelProviders.of(this,
            SumonnerViewModelFactory(SummonerRepository())
        )[SummonnerViewModel::class.java]

        btnSeatch.setOnClickListener {
            viewModel.name = etSummoner.text.toString()
            viewModel.model.value
            viewModel.model.observe(this, Observer(::updateUi))
        }
    }

    override fun initListeners() {
    }

    private fun updateUi(uiModel: UiModelSummoner) {

        loading.visibility = if (uiModel is UiModelSummoner.Loading) View.VISIBLE else View.GONE

        when (uiModel){
            is UiModelSummoner.Content -> {
                val summoner: Summoner = uiModel.summoner
                txt_profileIcon.text = summoner.profileIconId.toString()
                txt_name.text = summoner.name
                txt_summonerLevel.text = summoner.summonerLevel.toString()
                txt_accountId.text = summoner.accountId
                txt_id.text = summoner.id
            }
        }
    }
}