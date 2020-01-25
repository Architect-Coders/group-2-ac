package com.teamtwo.apilol.ui.champions

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.data.ChampionsRepository
import com.example.domain.Champion
import com.example.usecases.GetChampion
import com.example.usecases.UpdateChampion
import com.teamtwo.apilol.ApiLolAplication
import com.teamtwo.apilol.R
import com.teamtwo.apilol.loadUrl
import com.teamtwo.apilol.model.champions.RetrofitDataSource
import com.teamtwo.apilol.model.champions.RoomDataSource
import com.teamtwo.apilol.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_champion_detail.*

class ChampionDetailActivity : BaseActivity(R.layout.activity_champion_detail) {

    private lateinit var viewModel: ChampionDetailViewModel

    companion object {
        const val BASE_URL_HEADER = "http://ddragon.leagueoflegends.com/cdn/img/champion/splash/"
    }

    override fun initListeners() {
        fabFav.setOnClickListener { viewModel.onFavouriteClicked() }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onStart() {
        super.onStart()

        val championsRepository = ChampionsRepository(
            RoomDataSource((application as ApiLolAplication).db),
            RetrofitDataSource()
        )
        viewModel = ViewModelProviders.of(
            this,
            ChampionDetailViewModelFactory(
                intent.getStringExtra(this::class.java.canonicalName),
                GetChampion(championsRepository),
                UpdateChampion(championsRepository)
            )
        )[ChampionDetailViewModel::class.java]

        viewModel.champion.observe(this, Observer(::updateUI))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun updateUI(champion: Champion){

        supportActionBar?.title = champion.name

        with(champion.stats){
            tvHP.text = "$hp"
            tvMP.text = "$mp"
            tvSpeed.text = "$movespeed"
            tvArmor.text = "$armor"
            tvSpellBlock.text = "$spellblock"
            tvAttackRange.text = "$attackrange"
            tvHPRegen.text = "$hpregen"
            tvMPRegen.text = "$mpregen"
            tvCrit.text = "$crit"
            tvAttackDamage.text = "$attackdamage"
            tvAttackSpeed.text = "$attackspeed"
        }

        ivChampionBackground.loadUrl(BASE_URL_HEADER + champion.id + "_0.jpg")
        fabFav.setImageDrawable(
            if (champion.favourite) getDrawable(R.drawable.ic_star_on)
            else getDrawable(R.drawable.ic_star_off)
        )
    }
}