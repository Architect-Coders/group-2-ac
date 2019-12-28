package com.teamtwo.apilol.matches

import com.teamtwo.apilol.Queue
import com.teamtwo.apilol.Queues
import com.teamtwo.apilol.model.LOLService
import kotlin.Exception

class GetFeaturedMatchesUseCase (private val service: LOLService) {

    companion object {
        const val apiKey = "RGAPI-b8b2a114-9933-4154-9ae6-2c10183756e0"
    }

    suspend fun execute (): List<FeaturedGameInfo>? {

        return try {
            val response = service.featuredGamesAsync(apiKey)
            val body = response.body()
            if (response.isSuccessful && body != null) {
                mapResponseData(body)
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }

    private fun mapResponseData (response: FeaturedGamesResponse): List<FeaturedGameInfo> {
        return response.gameList?.map {
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
}

private fun Long.toQueue (): Queue? {

    return Queues.QUEUE_LIST.firstOrNull {
        it.queueId.toLong() == this
    }
}