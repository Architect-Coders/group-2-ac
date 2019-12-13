package com.teamtwo.apilol.matches

import android.content.Intent
import android.os.Bundle
import com.teamtwo.apilol.BaseActivity
import com.teamtwo.apilol.R
import com.teamtwo.apilol.toast

class MatchDetailActivity: BaseActivity(R.layout.activity_match_detail) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initWithData(intent)

    }
    override fun initListeners() {
    }

    private fun initWithData (intent: Intent) {

        if (intent.hasExtra("match") && intent.getParcelableExtra<FeaturedGameInfo>("match") != null) {

            showDetailUi (intent.getParcelableExtra("match"))
        } else {
            showErrorAndExit()
        }
    }

    private fun showDetailUi(data: FeaturedGameInfo) {

    }

    private fun showErrorAndExit () {

        toast("Ha ocurrido un error al mostrar la información de la partida.")
        this.finish()
    }
}
