package com.teamtwo.apilol.ui.spells

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teamtwo.apilol.R
import com.teamtwo.apilol.inflate
import com.teamtwo.apilol.loadUrl
import com.teamtwo.apilol.model.spells.Spell
import kotlinx.android.synthetic.main.spell_list_item.view.*

class SpellsAdapter(private val listener: (Spell) -> Unit ) :RecyclerView.Adapter<SpellsAdapter.ViewHolder>(){

    var items : List<Spell> = emptyList()

    companion object{
        const val  IMAGE_SPELL= "https://ddragon.leagueoflegends.com/cdn/9.24.2/img/spell/"
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(parent.inflate(R.layout.spell_list_item))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }




    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(spell: Spell)= with(itemView){

            tvNameSpell.text = spell.name
            ivSpell.loadUrl(IMAGE_SPELL + spell.image.full)
            clContent.setOnClickListener { listener(spell) }
        }
    }




}