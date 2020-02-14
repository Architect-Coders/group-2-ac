package com.teamtwo.apilol.ui

import android.content.Intent
import android.os.Bundle
import com.teamtwo.apilol.ui.spells.SpellsLsitActivity
import com.teamtwo.apilol.ui.matches.MatchListActivity
import com.teamtwo.apilol.ui.items.list.ItemListActivity
import com.teamtwo.apilol.ui.summoners.SummonersDetailActivity
import com.teamtwo.apilol.R
import com.teamtwo.apilol.ui.base.BaseActivity
import com.teamtwo.apilol.ui.champions.list.ChampionListActivity
import kotlinx.android.synthetic.main.activity_main.*

@kotlin.time.ExperimentalTime
class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun initListeners() {
      
        btnCarlos.setOnClickListener {
            startActivity(Intent(this, ChampionListActivity::class.java))
        }
        btnDaniel.setOnClickListener {
           startActivity(Intent(this, SummonersDetailActivity::class.java))
        }
        btnMary.setOnClickListener { 
            startActivity(Intent(this, SpellsLsitActivity::class.java)) 
        }
        btnJorge.setOnClickListener { 
            startActivity(Intent(this, MatchListActivity::class.java)) 
        }

        btnDavid.setOnClickListener {
            startActivity(Intent(this,
                ItemListActivity::class.java))
        }
      
    }
}
