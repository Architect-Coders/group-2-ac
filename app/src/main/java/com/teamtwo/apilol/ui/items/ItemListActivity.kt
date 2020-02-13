package com.teamtwo.apilol.ui.items

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.usecases.GetItems
import com.teamtwo.apilol.ApiLolAplication
import com.teamtwo.apilol.ui.base.BaseActivity
import com.teamtwo.apilol.R
import com.example.data.ItemsRepository
import com.teamtwo.apilol.model.items.RetrofitDataSource
import com.teamtwo.apilol.model.items.RoomDataSource
import com.teamtwo.apilol.ui.items.ItemListViewModel.UiModel
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.android.synthetic.main.loading.*

class ItemListActivity : BaseActivity(R.layout.activity_item_list) {

    private lateinit var viewModel: ItemListViewModel
    private lateinit var adapter: ItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "Items"

        viewModel = ViewModelProviders.of(this,
            ItemListViewModelFactory(
                GetItems(
                    ItemsRepository(
                        RoomDataSource((application as ApiLolAplication).db),
                        RetrofitDataSource()
                    )
                )
            )
        )[ItemListViewModel::class.java]

        rvItems.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        adapter = ItemsAdapter(viewModel::onItemClicked)
        rvItems.adapter = adapter

        viewModel.model.observe(this, Observer(::updateUi))
    }

    override fun onResume() {
        super.onResume()
        viewModel.refresh()
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
                        .putExtra(ItemDetailActivity::class.java.canonicalName, uiModel.item.id)
                )
        }
    }
}
