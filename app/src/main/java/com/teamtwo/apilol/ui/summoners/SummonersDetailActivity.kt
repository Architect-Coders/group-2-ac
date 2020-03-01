package com.teamtwo.apilol.ui.summoners

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.data.RemoteSummonerDataSource
import com.example.data.SummonersRepository
import com.example.domain.Summoner
import com.example.usecases.GetSummoner
import com.teamtwo.apilol.ApiLolAplication
import com.teamtwo.apilol.ui.base.BaseActivity
import com.teamtwo.apilol.R
import com.teamtwo.apilol.toast
import com.teamtwo.apilol.ui.spells.SpellListActivtyComponent
import com.teamtwo.apilol.ui.spells.SpellListActivtyModule
import kotlinx.android.synthetic.main.activity_summoner_detail.*
import kotlinx.android.synthetic.main.loading.*

class SummonersDetailActivity : BaseActivity(R.layout.activity_summoner_detail) {

    private lateinit var component: SummonerActivtyComponent

    private  val  viewModel by lazy {component.viewModel}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Summoner"

        component = (application as ApiLolAplication).summonerComponent.plus(SummonerActivtyModule())

        viewModel.model.observe(this, Observer(::updateUi))

        btnSearch.setOnClickListener {
            viewModel.reload(etSummoner.text.toString())
        }
    }

    override fun initListeners() {
    }

    private fun updateUi(uiModel: SummonerViewModel.UiModelSummoner) {

        loading.visibility = if (uiModel is SummonerViewModel.UiModelSummoner.Loading) View.VISIBLE else View.GONE

        when (uiModel){
            is SummonerViewModel.UiModelSummoner.Content -> {
                val summoner: Summoner = uiModel.summoner
                txt_profileIcon.text = summoner.profileIconId.toString()
                txt_name.text = summoner.name
                txt_summonerLevel.text = summoner.summonerLevel.toString()
                txt_accountId.text = summoner.accountId
                txt_id.text = summoner.id
            }
            is SummonerViewModel.UiModelSummoner.Error -> {
                toast("Usuario no encontrado")
            }
        }
    }
}