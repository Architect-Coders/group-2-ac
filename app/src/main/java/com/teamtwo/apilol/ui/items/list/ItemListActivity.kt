package com.teamtwo.apilol.ui.items.list

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.teamtwo.apilol.ApiLolAplication
import com.teamtwo.apilol.ui.base.BaseActivity
import com.teamtwo.apilol.R
import com.teamtwo.apilol.getViewModel
import com.teamtwo.apilol.ui.items.detail.ItemDetailActivity
import com.teamtwo.apilol.ui.items.list.ItemListViewModel.UiModel
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.android.synthetic.main.loading.*

class ItemListActivity : BaseActivity(R.layout.activity_item_list) {

    private lateinit var component: ItemListActivityComponent
    private val viewModel by lazy { getViewModel { component.viewModel } }

    private lateinit var adapter: ItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        component = (application as ApiLolAplication).itemsComponent.plus(ItemListActivityModule())

        supportActionBar?.title = "Items"

        rvItems.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        adapter =
            ItemsAdapter(viewModel::onItemClicked)
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
                        .putExtra(ItemDetailActivity::class.java.canonicalName, uiModel.item.id.toString())
                )
        }
    }
}
