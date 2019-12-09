package com.teamtwo.apilol

import android.content.Intent
import android.os.Bundle
import com.teamtwo.apilol.Sensor.CountryCode
import com.teamtwo.apilol.Sensor.GpsLocation
import com.teamtwo.apilol.items.ItemListActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GpsLocation(this)
    }

    override fun initListeners() {
        btnCarlos.setOnClickListener { toast("Carlos") }
        btnDaniel.setOnClickListener { toast("Daniel") }
        btnDavid.setOnClickListener {
            startActivity(Intent(this,ItemListActivity::class.java))
        }
        btnJorge.setOnClickListener { toast("Jorge") }
        btnMary.setOnClickListener { toast("Mary") }
    }
}
