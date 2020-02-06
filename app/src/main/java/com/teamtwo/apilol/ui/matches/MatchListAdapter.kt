package com.teamtwo.apilol.ui.matches

import android.view.View
import android.view.ViewGroup
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.FeaturedGameInfo
import com.example.domain.Participant
import com.teamtwo.apilol.R
import com.teamtwo.apilol.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.cell_featured_match.*

class MatchListAdapter(private val listener: (FeaturedGameInfo) -> Unit)
    : ListAdapter<FeaturedGameInfo, MatchListAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = parent.inflate(R.layout.cell_featured_match)
        return ViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(getItem(position))
    }

    class ViewHolder (override val containerView: View,
                      private val listener: (FeaturedGameInfo) -> Unit): RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindItem (gameInfo: FeaturedGameInfo) {

            containerView.setOnClickListener { listener.invoke(gameInfo) }
            gameIdText.text = gameInfo.gameId.toString()
            participantsText.text = prepareParticipants(gameInfo.participants)
        }

        private fun prepareParticipants (participants: List<Participant>): CharSequence {
            return buildSpannedString {
                participants.forEach {
                    append(it.summonerName + " ")
                    bold { "(${it.championId})" }
                    appendln()
                }
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object: DiffUtil.ItemCallback<FeaturedGameInfo>() {

            override fun areItemsTheSame(oldItem: FeaturedGameInfo,
                                         newItem: FeaturedGameInfo): Boolean {
                return oldItem.gameId == newItem.gameId
            }

            override fun areContentsTheSame(oldItem: FeaturedGameInfo,
                                            newItem: FeaturedGameInfo): Boolean {
                return oldItem == newItem
            }
        }
    }
}
