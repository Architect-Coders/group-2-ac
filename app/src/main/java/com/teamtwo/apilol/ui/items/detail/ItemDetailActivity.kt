package com.teamtwo.apilol.ui.items.detail

import androidx.lifecycle.Observer
import com.example.domain.Item
import com.teamtwo.apilol.ApiLolAplication
import com.teamtwo.apilol.ui.base.BaseActivity
import com.teamtwo.apilol.R
import com.teamtwo.apilol.loadUrl
import kotlinx.android.synthetic.main.activity_item_detail.*

class ItemDetailActivity : BaseActivity(R.layout.activity_item_detail) {

    private lateinit var component: ItemDetailActivityComponent
    private val viewModel by lazy { component.itemDetailViewModel }

    companion object {
        const val BASE_URL_BACKGROUND = "https://ddragon.leagueoflegends.com/cdn/9.24.2/img/item/"
    }

    override fun initListeners() {
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onStart() {
        super.onStart()

        component = (application as ApiLolAplication).itemsComponent.plus(
            ItemDetailActivityModule(intent.getStringExtra(this::class.java.canonicalName))
        )

        viewModel.item.observe(this, Observer(::updateUI))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun updateUI(item: Item){

        supportActionBar?.title = item.name
        tvName.text = item.name

        var description = item.description.replace("<stats>","")
        tvDescription.text = description.replace("</stats>","")

        with(item.image){

            ivImage.loadUrl(BASE_URL_BACKGROUND +"$full")
        }

        with(item.gold){

            tvBuyGold.text = "$total"
            tvSellGold.text = "$sell"
        }
    }
}
