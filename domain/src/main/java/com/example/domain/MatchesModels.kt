package com.example.domain

data class FeaturedGamesResponse (
    val clientRefreshInterval: Long?,
    val gameList: List<FeaturedGameInfoService>?
)

data class FeaturedGameInfoService (
    val gameId: Long?,
    val gameStartTime: Long?,
    val platformId: String?,
    val gameMode: String?,
    val mapId: Long?,
    val gameType: String?,
    val bannedChampions: List<BannedChampionService>?,
    val observers: ObserverService?,
    val participants: List<ParticipantService>?,
    val gameLength: Long?,
    val gameQueueConfigId: Long?
)

data class BannedChampionService (
    val pickTurn: Int?,
    val championId: Long?,
    val teamId: Long?
)

data class ObserverService (
    val encryptionKey: String?
)

data class ParticipantService (
    val profileIconId: Long?,
    val championId: Long?,
    val summonerName: String?,
    val bot: Boolean?,
    val spell2Id: Long?,
    val teamId: Long?,
    val spell1Id: Long?
)

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
)

data class BannedChampion (
    val pickTurn: Int,
    val championId: Long,
    val teamId: Long
)

data class Observer (
    val encryptionKey: String
)

data class Participant (
    val profileIconId: Long,
    val championId: Long,
    val summonerName: String,
    val bot: Boolean,
    val spell2Id: Long,
    val teamId: Long,
    val spell1Id: Long
)

data class Queue (
    val queueId: Int,
    val map: String,
    val description: String?,
    val notes: String?
)

