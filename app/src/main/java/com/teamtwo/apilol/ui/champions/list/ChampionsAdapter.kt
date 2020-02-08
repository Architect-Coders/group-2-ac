package com.teamtwo.apilol.ui.champions.list

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.Champion
import com.teamtwo.apilol.R
import com.teamtwo.apilol.inflate
import com.teamtwo.apilol.loadUrl
import kotlinx.android.synthetic.main.champion_list_item.view.*

class ChampionsAdapter(
    private val listener: (Champion) -> Unit
): RecyclerView.Adapter<ChampionsAdapter.ViewHolder>() {

    var championList: List<Champion> = emptyList()

    companion object {
        const val SQUARE_BASE_URL = "https://ddragon.leagueoflegends.com/cdn/9.23.1/img/champion/"
    }

    override fun getItemCount() = championList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(
        parent.inflate(
            R.layout.champion_list_item,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val champion = championList[position]
        holder.bind(champion)
        holder.itemView.setOnClickListener { listener(champion) }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(champion: Champion){
            itemView.tvChampionName.text = champion.name

            if (champion.favourite) itemView.tvChampionName.showFavouriteIcon()
            else itemView.tvChampionName.hideFavouriteIcon()

            itemView.ivChampion.loadUrl(SQUARE_BASE_URL + champion.image.full)
        }

        private fun TextView.hideFavouriteIcon() = this.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0)
        private fun TextView.showFavouriteIcon() = this.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_star_on, 0)
    }
}