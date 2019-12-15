package com.teamtwo.apilol.items

import com.teamtwo.apilol.BaseActivity
import com.teamtwo.apilol.R
import com.teamtwo.apilol.loadUrl
import com.teamtwo.apilol.model.items.Item
import kotlinx.android.synthetic.main.activity_item_detail.*

class ItemDetailActivity : BaseActivity(R.layout.activity_item_detail) {

    companion object {
        const val BASE_URL_BACKGROUND = "http://ddragon.leagueoflegends.com/cdn/9.24.2/img/item/"
    }

    override fun initListeners() {}

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onStart() {
        super.onStart()
        val item = intent.getParcelableExtra(this::class.java.canonicalName) as Item

        tvName.text = item.name
        tvDescription.text = item.description

        with(item.image){

            ivImage.loadUrl(BASE_URL_BACKGROUND+"$full")
        }

        with(item.gold){

            tvBuyGold.text = "$total"
            tvSellGold.text = "$sell"
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = item.name

    }
}
