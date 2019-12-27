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

    override fun initListeners() {}

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onStart() {
        super.onStart()
        val champion = intent.getParcelableExtra(this::class.java.canonicalName) as Champion

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

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        supportActionBar?.title = champion.name
        ivChampionBackground.loadUrl(BASE_URL_BACKGROUND + champion.id + "_0.jpg")
    }
}