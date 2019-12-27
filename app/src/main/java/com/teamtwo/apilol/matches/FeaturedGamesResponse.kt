package com.teamtwo.apilol.matches

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

