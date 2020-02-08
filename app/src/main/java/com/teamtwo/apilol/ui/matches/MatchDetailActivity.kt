package com.teamtwo.apilol.ui.matches

import android.content.Intent
import android.os.Bundle
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import androidx.core.text.underline
import com.example.domain.FeaturedGameInfo
import com.example.domain.Participant
import com.google.gson.Gson
import com.teamtwo.apilol.ui.base.BaseActivity
import com.teamtwo.apilol.R
import com.teamtwo.apilol.toast
import kotlinx.android.synthetic.main.activity_match_detail.*
import kotlinx.android.synthetic.main.activity_match_detail.gameIdText
import kotlinx.android.synthetic.main.activity_match_detail.participantGroup1
import kotlinx.android.synthetic.main.activity_match_detail.participantGroup2
import kotlinx.android.synthetic.main.cell_featured_match.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.time.seconds

@kotlin.time.ExperimentalTime
class MatchDetailActivity: BaseActivity(R.layout.activity_match_detail) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initWithData(intent)

    }
    override fun initListeners() {
    }

    private fun initWithData (intent: Intent) {

        if (intent.hasExtra("match") && intent.getStringExtra("match") != null) {

            showDetailUi (Gson().fromJson(intent.getStringExtra("match"), FeaturedGameInfo::class.java))
        } else {
            showErrorAndExit()
        }
    }

    private fun showDetailUi(data: FeaturedGameInfo) {
        gameIdText.text = data.gameId.toString()
        participantGroup1.text = prepareParticipants(data.participants.filter { it.teamId == 100L }, 1)
        participantGroup2.text = prepareParticipants(data.participants.filter { it.teamId == 200L }, 2)
        startTimeText.text = "Hora de comienzo: ${formatStartTime(data.gameStartTime)}"
        durationText.text = "Duración de la partida: ${formatMatchDuration(data.gameLength)} minutos."
    }

    private fun showErrorAndExit () {

        toast("Ha ocurrido un error al mostrar la información de la partida.")
        this.finish()
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

    private fun formatStartTime (startTime: Long): String {
        val sdf = SimpleDateFormat("dd/MM/YYYY HH:mm", Locale.getDefault())
        return sdf.format(startTime)
    }

    @kotlin.time.ExperimentalTime
    private fun formatMatchDuration (duration: Long): Int {
        return duration.seconds.inMinutes.toInt()
    }
}
