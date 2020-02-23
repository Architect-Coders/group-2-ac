package com.teamtwo.apilol.model.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.BannedChampion
import com.example.domain.Observer
import com.example.domain.Participant
import com.example.domain.Queue

@Entity
data class MatchesEntity (
    @PrimaryKey val gameId: Long,
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
)