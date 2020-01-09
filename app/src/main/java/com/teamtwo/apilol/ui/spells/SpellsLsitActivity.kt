package com.teamtwo.apilol.ui.spells

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.teamtwo.apilol.ui.base.BaseActivity
import com.teamtwo.apilol.R
import com.teamtwo.apilol.model.SpellsRepository
import kotlinx.android.synthetic.main.activity_spells_list.*

class SpellsLsitActivity : BaseActivity(R.layout.activity_spells_list) {

    private lateinit var  viewModel: SpellsListViewModel
    private lateinit var adapter: SpellsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this,
            SpellsListViewModel.SpellsListViewModelFactory(SpellsRepository()))[SpellsListViewModel::class.java]
        initList()
        initObserver()
    }

    private fun initObserver() {
        viewModel.state.observe(this, Observer  (::updateList) )
    }


    private fun initList() {

        rvSpells.layoutManager = LinearLayoutManager(this)
        adapter = SpellsAdapter(viewModel:: onSpellClicked)
        rvSpells.adapter = adapter

    }

    private fun updateList(state: SpellsListViewModel.ViewState) {
        when(state){
            is SpellsListViewModel.ViewState.ShowList -> {
                adapter.items = state.spells
                adapter.notifyDataSetChanged()

            }
            is SpellsListViewModel.ViewState.Navegation ->{
                startActivity(Intent (this, SpellDetailActivity::class.java).putExtra(SpellDetailActivity::class.java.canonicalName, state.spell))
            }
        }
    }

    override fun initListeners() {
    }




}