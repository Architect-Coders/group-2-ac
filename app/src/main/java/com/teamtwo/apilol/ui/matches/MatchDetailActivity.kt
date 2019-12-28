package com.teamtwo.apilol.ui.matches

import android.content.Intent
import android.os.Bundle
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.teamtwo.apilol.ui.base.BaseActivity
import com.teamtwo.apilol.R
import com.teamtwo.apilol.toast
import kotlinx.android.synthetic.main.activity_match_detail.*
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

        if (intent.hasExtra("match") && intent.getParcelableExtra<FeaturedGameInfo>("match") != null) {

            showDetailUi (intent.getParcelableExtra("match"))
        } else {
            showErrorAndExit()
        }
    }

    private fun showDetailUi(data: FeaturedGameInfo) {
        gameIdText.text = data.gameId.toString()
        participantsText.text = prepareParticipants(data.participants)
        startTimeText.text = "Hora de comienzo: ${formatStartTime(data.gameStartTime)}"
        durationText.text = "Duración de la partida: ${formatMatchDuration(data.gameLength)}"
    }

    private fun showErrorAndExit () {

        toast("Ha ocurrido un error al mostrar la información de la partida.")
        this.finish()
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

    private fun formatStartTime (startTime: Long): String {
        val sdf = SimpleDateFormat("dd/MM/YYYY HH:mm", Locale.getDefault())
        return sdf.format(startTime)
    }

    @kotlin.time.ExperimentalTime
    private fun formatMatchDuration (duration: Long): Int {
        return duration.seconds.inMinutes.toInt()
    }
}
