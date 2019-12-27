package com.teamtwo.apilol

import android.app.Application
import android.os.Bundle
import com.teamtwo.apilol.sensor.CountryCode
import com.teamtwo.apilol.sensor.GpsLocation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GpsLocation(applicationContext as Application)
    }

    override fun initListeners() {
        btnCarlos.setOnClickListener { toast("Carlos") }
        btnDaniel.setOnClickListener { toast("Daniel") }
        btnDavid.setOnClickListener {
            toast(CountryCode(application).getCode())
        }
        btnJorge.setOnClickListener { toast("Jorge") }
        btnMary.setOnClickListener { toast("Mary") }
    }
}
