package com.teamtwo.apilol.ui.items

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.data.ItemsRepository
import com.example.domain.Item
import com.example.usecases.GetItem
import com.teamtwo.apilol.ApiLolAplication
import com.teamtwo.apilol.ui.base.BaseActivity
import com.teamtwo.apilol.R
import com.teamtwo.apilol.loadUrl
import com.teamtwo.apilol.model.items.RetrofitDataSource
import com.teamtwo.apilol.model.items.RoomDataSource
import kotlinx.android.synthetic.main.activity_item_detail.*

class ItemDetailActivity : BaseActivity(R.layout.activity_item_detail) {

    private lateinit var viewModel: ItemDetailViewModel

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

        val itemsRepository = ItemsRepository(
            RoomDataSource((application as ApiLolAplication).db),
            RetrofitDataSource()
        )
        viewModel = ViewModelProviders.of(
            this,
            ItemDetailViewModelFactory(
                intent.getStringExtra(this::class.java.canonicalName),
                GetItem(itemsRepository)
            )
        )[ItemDetailViewModel::class.java]

        viewModel.item.observe(this, Observer(::updateUI))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun updateUI(item: Item){

        supportActionBar?.title = item.name
        tvName.text = item.name
        tvDescription.text = item.description

        with(item.image){

            ivImage.loadUrl(BASE_URL_BACKGROUND+"$full")
        }

        with(item.gold){

            tvBuyGold.text = "$total"
            tvSellGold.text = "$sell"
        }
    }
}
