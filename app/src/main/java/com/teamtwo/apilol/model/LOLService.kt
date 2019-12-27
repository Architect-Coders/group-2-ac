package com.teamtwo.apilol.model

import com.teamtwo.apilol.matches.FeaturedGamesResponse
import com.teamtwo.apilol.model.items.ItemsResponse
import com.teamtwo.apilol.model.champions.ChampionsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LOLService {

    /* Architect Codders Example

    @GET("discover/movie?sort_by=popularity.desc")
    suspend fun listPopularMoviesAsync(
        @Query("api_key") apiKey: String,
        @Query("region") region: String
    ): Response<MovieDbResult>

    */

    @GET("spectator/v4/featured-games")
    suspend fun featuredGamesAsync(@Header("X-Riot-Token") apiKey: String): Response<FeaturedGamesResponse>

    @GET("data/{countryCode}/item.json")
    suspend fun getAllItems(@Path(value="countryCode", encoded=false) countryCode: String): Response<ItemsResponse>

    @GET("data/en_US/champion.json")
    suspend fun getChampions(): Response<ChampionsResponse>
}