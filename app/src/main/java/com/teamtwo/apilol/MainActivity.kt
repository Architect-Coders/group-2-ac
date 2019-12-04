package com.teamtwo.apilol

import android.content.Context
import android.os.Bundle

class MainActivity : BaseActivity(Context.BIND_AUTO_CREATE) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toast("Primer edit")
    }
}
