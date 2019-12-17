package com.teamtwo.apilol.model

import com.teamtwo.apilol.model.champions.ChampionsResponse
import com.teamtwo.apilol.model.sumonners.Summoner
import retrofit2.Response
import retrofit2.http.*

interface LOLService {

    /* Architect Codders Example

    @GET("discover/movie?sort_by=popularity.desc")
    suspend fun listPopularMoviesAsync(
        @Query("api_key") apiKey: String,
        @Query("region") region: String
    ): Response<MovieDbResult>

    */

    @GET("data/en_US/champion.json")
    suspend fun getChampions(): Response<ChampionsResponse>

    @Headers("X-Riot-Token: RGAPI-2ab833a6-db10-4628-bec7-a125a12faa86")
    @GET("summoner/v4/summoners/by-name/{value}")
    suspend fun getSummoner(@Path("value") summonerName: String): Response<Summoner>
}