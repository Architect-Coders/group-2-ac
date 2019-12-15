package com.teamtwo.apilol.items

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.teamtwo.apilol.BaseActivity
import com.teamtwo.apilol.R
import com.teamtwo.apilol.model.ItemsRepository
import com.teamtwo.apilol.items.ItemListViewModel.UiModel
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.android.synthetic.main.loading.*

class ItemListActivity : BaseActivity(R.layout.activity_item_list) {

    private lateinit var viewModel: ItemListViewModel
    private lateinit var adapter: ItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Items"

        viewModel = ViewModelProviders.of(this,
            ChampionListViewModelFactory(ItemsRepository())
        )[ItemListViewModel::class.java]

        rvItems.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        adapter = ItemsAdapter(viewModel::onItemClicked)
        rvItems.adapter = adapter

        viewModel.model.observe(this, Observer(::updateUi))
    }

    override fun initListeners() {
    }

    private fun updateUi(uiModel: UiModel) {

        loading.visibility = if (uiModel is UiModel.Loading) View.VISIBLE else View.GONE

        when (uiModel){
            is UiModel.Content -> {
                adapter.itemList = uiModel.items
                adapter.notifyDataSetChanged()
            }
            is UiModel.Navigation ->
                startActivity(
                    Intent(this, ItemDetailActivity::class.java)
                        .putExtra(ItemDetailActivity::class.java.canonicalName, uiModel.item)
                )
        }
    }
}
