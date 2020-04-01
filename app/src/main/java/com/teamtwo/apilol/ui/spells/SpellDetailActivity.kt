package com.teamtwo.apilol.ui.spells

import android.content.Intent
import android.os.Bundle
import com.example.domain.Spell
import com.google.gson.Gson
import com.teamtwo.apilol.R
import com.teamtwo.apilol.loadUrl
import com.teamtwo.apilol.toast
import com.teamtwo.apilol.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail_spell.*

class SpellDetailActivity : BaseActivity(R.layout.activity_detail_spell) {



    companion object{
        const val  IMAGE_SPELL= "https://ddragon.leagueoflegends.com/cdn/9.24.2/img/spell/"
        const val spell = "spell"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView(intent)
    }
    private fun initView (intent: Intent) {

        if (intent.hasExtra(spell)
            && intent.getStringExtra(spell) != null) {
            showDetailUi (Gson().fromJson(intent.getStringExtra(spell), Spell::class.java))
        } else {
            showError()
        }
    }


    override fun initListeners() {
    }



    private fun showError() {
        toast("Error no se pueden mostrar los hechizos")
        this.finish()
    }


    private fun showDetailUi(spell: Spell){

        with(spell){
            tvNameSpelL.text = "$name"
            tvDescription.text = "$description"
            tvCostType.text="$costType"
            tvMaxRank.text="$maxrank"
            tvTooltipe.text="$tooltip"
            tvRespurce.text="$resource"
        }
        ivSpell.loadUrl(IMAGE_SPELL + spell.image.full)

    }
}