package com.teamtwo.apilol.champions

import com.teamtwo.apilol.BaseActivity
import com.teamtwo.apilol.R
import com.teamtwo.apilol.loadUrl
import com.teamtwo.apilol.model.champions.Champion
import kotlinx.android.synthetic.main.activity_champion_detail.*

class ChampionDetailActivity : BaseActivity(R.layout.activity_champion_detail) {

    companion object {
        const val BASE_URL_BACKGROUND = "https://ddragon.leagueoflegends.com/cdn/img/champion/loading/"
    }

    private var champion: Champion? = null

    override fun initListeners() {}

    override fun onStart() {
        super.onStart()
        champion = intent.getParcelableExtra(this::class.java.canonicalName)

        champion?.let {
            supportActionBar?.title = it.name
            ivChampionBackground.loadUrl(BASE_URL_BACKGROUND + it.id + "_0.jpg")
        }
    }
}