package com.teamtwo.apilol.ui.spells

import com.teamtwo.apilol.ui.base.BaseActivity
import com.teamtwo.apilol.R
import com.teamtwo.apilol.loadUrl
import com.teamtwo.apilol.model.spells.Spell
import kotlinx.android.synthetic.main.activity_detail_spell.*

class SpellDetailActivity : BaseActivity(R.layout.activity_detail_spell) {

    companion object{
        const val  IMAGE_SPELL= "https://ddragon.leagueoflegends.com/cdn/9.24.2/img/spell/"
    }


    override fun initListeners() {
    }

    override fun onStart() {
        super.onStart()
        val spell = intent.getParcelableExtra(this::class.java.canonicalName) as Spell

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