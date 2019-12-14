package com.teamtwo.apilol

import android.content.Intent
import android.os.Bundle
import com.teamtwo.apilol.matches.MatchListActivity
import kotlinx.android.synthetic.main.activity_main.*

@kotlin.time.ExperimentalTime
class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initListeners() {
        btnCarlos.setOnClickListener { toast("Carlos") }
        btnDaniel.setOnClickListener { toast("Daniel") }
        btnDavid.setOnClickListener { toast("David") }
        btnJorge.setOnClickListener { startActivity(Intent(this, MatchListActivity::class.java)) }
        btnMary.setOnClickListener { toast("Mary") }
    }
}
