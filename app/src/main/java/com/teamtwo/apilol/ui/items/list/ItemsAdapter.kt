package com.teamtwo.apilol.ui.items.list

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.Item
import com.teamtwo.apilol.R
import com.teamtwo.apilol.inflate
import com.teamtwo.apilol.loadUrl
import kotlinx.android.synthetic.main.item_list_item.view.*

class ItemsAdapter(private val listener: (Item) -> Unit): RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    var itemList: List<Item> = emptyList()

    companion object {
        const val SQUARE_BASE_URL = "https://ddragon.leagueoflegends.com/cdn/9.24.2/img/item/"
    }

    override fun getItemCount() = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(
        parent.inflate(
            R.layout.item_list_item,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item) }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Item){
            itemView.ivItem.loadUrl(SQUARE_BASE_URL + item.image.full)
            itemView.tvItemName.text = item.name
        }
    }
}