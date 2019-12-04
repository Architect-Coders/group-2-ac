package com.teamtwo.apilol

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initListeners() {
        btnCarlos.setOnClickListener { toast("Carlos") }
        btnDaniel.setOnClickListener { toast("Daniel") }
        btnDavid.setOnClickListener { toast("David") }
        btnJorge.setOnClickListener { toast("Jorge") }
        btnMary.setOnClickListener { toast("Mary") }
    }
}
