package com.teamtwo.apilol.ui.champions

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teamtwo.apilol.R
import com.teamtwo.apilol.inflate
import com.teamtwo.apilol.loadUrl
import com.teamtwo.apilol.model.champions.Champion
import kotlinx.android.synthetic.main.champion_list_item.view.*

class ChampionsAdapter(private val listener: (Champion) -> Unit): RecyclerView.Adapter<ChampionsAdapter.ViewHolder>() {

    var championList: List<Champion> = emptyList()

    companion object {
        const val SQUARE_BASE_URL = "https://ddragon.leagueoflegends.com/cdn/9.23.1/img/champion/"
    }

    override fun getItemCount() = championList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(parent.inflate(R.layout.champion_list_item, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val champion = championList[position]
        holder.bind(champion)
        holder.itemView.setOnClickListener { listener(champion) }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(champion: Champion){
            itemView.tvChampionName.text = champion.name
            itemView.ivChampion.loadUrl(SQUARE_BASE_URL + champion.image.full)
        }
    }
}