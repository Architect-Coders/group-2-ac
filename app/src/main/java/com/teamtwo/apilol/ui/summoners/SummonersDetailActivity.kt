package com.teamtwo.apilol.ui.summoners

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.teamtwo.apilol.ui.base.BaseActivity
import com.teamtwo.apilol.R
import com.teamtwo.apilol.ui.summoners.SummonnerViewModel.UiModelSummoner
import com.teamtwo.apilol.model.SummonerRepository
import com.teamtwo.apilol.model.sumonners.Summoner
import com.teamtwo.apilol.toast
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

        viewModel.model.observe(this, Observer(::updateUi))

        btnSearch.setOnClickListener {
            viewModel.reload(etSummoner.text.toString())
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
            is UiModelSummoner.Error -> {
                toast("Usuario no encontrado")
            }
        }
    }
}