package com.teamtwo.apilol.model.matches

import com.example.domain.*
import com.teamtwo.apilol.Queues
import com.teamtwo.apilol.model.database.entities.MatchesEntity

fun FeaturedGamesResponse.mapResponseData(): List<FeaturedGameInfo> {
    return this.gameList?.map {
        FeaturedGameInfo(
            it.gameId ?: 0L,
            it.gameStartTime ?: 0L,
            it.platformId ?: "",
            it.gameMode ?: "",
            it.mapId ?: 0L,
            it.gameType ?: "",
            it.bannedChampions?.map { champion ->
                BannedChampion(
                    champion.pickTurn ?: 0,
                    champion.championId ?: 0L,
                    champion.teamId ?: 0L
                )
            } ?: emptyList<BannedChampion>(),
            Observer(it.observers?.encryptionKey ?: ""),
            it.participants?.map { participant ->
                Participant(
                    participant.profileIconId ?: 0L,
                    participant.championId ?: 0L,
                    participant.summonerName ?: "",
                    participant.bot ?: false,
                    participant.spell2Id ?: 0L,
                    participant.teamId ?: 0L,
                    participant.spell1Id ?: 0L
                )
            } ?: emptyList<Participant>(),
            it.gameLength ?: 0L,
            it.gameQueueConfigId?.toQueue()
        )
    } ?: emptyList()
}

private fun Long.toQueue (): Queue? {

    return Queues.QUEUE_LIST.firstOrNull {
        it.queueId.toLong() == this
    }
}

fun FeaturedGameInfo.toDbEntity(): MatchesEntity = MatchesEntity(
    gameId,
    gameStartTime,
    platformId,
    gameMode,
    mapId,
    gameType,
    bannedChampions,
    observers,
    participants,
    gameLength,
    gameQueue
)

fun MatchesEntity.toDomainObject(): FeaturedGameInfo = FeaturedGameInfo(
    gameId,
    gameStartTime,
    platformId,
    gameMode,
    mapId,
    gameType,
    bannedChampions,
    observers,
    participants,
    gameLength,
    gameQueue
)