package com.teamtwo.apilol.ui.spells

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.teamtwo.apilol.ui.base.BaseActivity
import com.teamtwo.apilol.R
import com.google.gson.Gson
import com.teamtwo.apilol.ApiLolAplication
import kotlinx.android.synthetic.main.activity_spells_list.*

class SpellsLsitActivity : BaseActivity(R.layout.activity_spells_list) {

    private lateinit var component: SpellListActivtyComponent

    private  val  viewModel by lazy {component.viewModel}
    private lateinit var adapter: SpellsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component = (application as ApiLolAplication).spellsComponent.plus(SpellListActivtyModule())

        initList()
        initObserver()
    }

    private fun initObserver() {
        viewModel.state.observe(this, Observer  (::updateList) )
        viewModel.refresh()
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
                startActivity(Intent(this@SpellsLsitActivity, SpellDetailActivity::class.java).apply {
                    putExtra(SpellDetailActivity.spell, Gson().toJson(state.spell))
                })            }
        }
    }

    override fun initListeners() {
    }




}