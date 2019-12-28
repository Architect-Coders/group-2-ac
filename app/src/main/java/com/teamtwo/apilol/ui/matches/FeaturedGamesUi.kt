package com.teamtwo.apilol.ui.matches

import android.os.Parcelable
import com.teamtwo.apilol.Queue
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FeaturedGameInfo (
    val gameId: Long,
    val gameStartTime: Long,
    val platformId: String,
    val gameMode: String,
    val mapId: Long,
    val gameType: String,
    val bannedChampions: List<BannedChampion>,
    val observers: Observer,
    val participants: List<Participant>,
    val gameLength: Long,
    val gameQueue: Queue?
): Parcelable

@Parcelize
data class BannedChampion (
    val pickTurn: Int,
    val championId: Long,
    val teamId: Long
): Parcelable

@Parcelize
data class Observer (
    val encryptionKey: String
): Parcelable

@Parcelize
data class Participant (
    val profileIconId: Long,
    val championId: Long,
    val summonerName: String,
    val bot: Boolean,
    val spell2Id: Long,
    val teamId: Long,
    val spell1Id: Long
): Parcelable