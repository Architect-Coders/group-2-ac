package com.teamtwo.apilol

import android.content.Intent
import android.os.Bundle
import com.teamtwo.apilol.champions.ChampionListActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initListeners() {
        btnCarlos.setOnClickListener {
            startActivity(Intent(this, ChampionListActivity::class.java))
        }
        btnDaniel.setOnClickListener { toast("Daniel") }
        btnDavid.setOnClickListener { toast("David") }
        btnJorge.setOnClickListener { toast("Jorge") }
        btnMary.setOnClickListener { toast("Mary") }
    }
}
