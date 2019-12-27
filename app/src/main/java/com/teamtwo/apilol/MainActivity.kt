package com.teamtwo.apilol

import android.content.Intent
import com.teamtwo.apilol.matches.MatchListActivity
import com.teamtwo.apilol.items.ItemListActivity
import com.teamtwo.apilol.champions.ChampionListActivity
import android.app.Application
import android.os.Bundle
import com.teamtwo.apilol.sensor.CountryCode
import com.teamtwo.apilol.sensor.GpsLocation
import kotlinx.android.synthetic.main.activity_main.*

@kotlin.time.ExperimentalTime
class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GpsLocation(applicationContext as Application)
    }

    override fun initListeners() {
        btnCarlos.setOnClickListener {
            startActivity(Intent(this, ChampionListActivity::class.java))
        }
      
        btnDaniel.setOnClickListener { toast("Daniel") }
      
        btnJorge.setOnClickListener { 
            startActivity(Intent(this, MatchListActivity::class.java)) 
        }
      
        btnDavid.setOnClickListener {
            startActivity(Intent(this,ItemListActivity::class.java))
        }
      
        btnMary.setOnClickListener { toast("Mary") }
    }
}
