package com.teamtwo.apilol.ui.matches

import android.view.View
import android.view.ViewGroup
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import androidx.core.text.underline
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.FeaturedGameInfo
import com.example.domain.Participant
import com.teamtwo.apilol.R
import com.teamtwo.apilol.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.cell_featured_match.*
import kotlinx.android.synthetic.main.cell_match_type.*

class MatchListAdapter(private val listener: (FeaturedGameInfo) -> Unit)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items: MutableList<ListItem> = mutableListOf()

    fun setData(recentItems: List<FeaturedGameInfo>, oldItems: List<FeaturedGameInfo>) {

        items.clear()
        if (recentItems.isNotEmpty()) {
            items.add(HeaderItem("Partidas recientes"))
            items.addAll(recentItems.map { RowItem(it, true) })
        }
        items.add(HeaderItem("Partidas pasadas"))
        items.addAll(oldItems.map { RowItem(it, false) })

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == 0) {
            val view = parent.inflate(R.layout.cell_match_type)
            HeaderViewHolder(view)
        } else {
            val view = parent.inflate(R.layout.cell_featured_match)
            RowViewHolder(view, listener)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (items.isEmpty()) {
            return
        }

        when (holder) {
            is HeaderViewHolder -> holder.bindHeader(items[position])
            is RowViewHolder -> holder.bindItem(items[position])
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        if (items.isEmpty()) {
            return 0
        }
        return if (items[position].isHeader) 0 else 1
    }

    class RowViewHolder (override val containerView: View,
                         private val listener: (FeaturedGameInfo) -> Unit): RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindItem (item: ListItem) {

            check(item is RowItem) { "Incorrect type of item received." }

            with(item.gameInfo) {
                containerView.setOnClickListener { listener.invoke(this) }
                gameIdText.text = "${this.gameMode} - ${this.gameType}"
                participantGroup1.text = prepareParticipants(this.participants.filter { it.teamId == 100L }, 1)
                participantGroup2.text = prepareParticipants(this.participants.filter { it.teamId == 200L }, 2)
            }
        }

        private fun prepareParticipants (participants: List<Participant>, group: Int): CharSequence {
            return buildSpannedString {
                underline {
                    bold {
                        append("Grupo $group")
                    }
                }
                appendln()
                participants.forEach {
                    append(it.summonerName + " ")
                    bold { "(${it.championId})" }
                    appendln()
                }
            }
        }
    }

    class HeaderViewHolder (override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindHeader (item: ListItem) {

            check(item is HeaderItem) { "Incorrect type of item received." }

            with(item) {
                headerTitle.text = this.title
            }

        }
    }

    open class ListItem (
        val isHeader: Boolean
    )

    data class HeaderItem(
        val title: String
    ): ListItem(isHeader = true)

    data class RowItem (
        val gameInfo: FeaturedGameInfo,
        val isRecent: Boolean
    ): ListItem(isHeader = false)
}
