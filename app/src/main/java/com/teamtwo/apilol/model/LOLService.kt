package com.teamtwo.apilol.model

import com.example.domain.*
import com.example.domain.ChampionsResponse
import com.example.domain.ItemsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface LOLService {


    /* Architect Codders Example

    @GET("discover/movie?sort_by=popularity.desc")
    suspend fun listPopularMoviesAsync(
        @Query("api_key") apiKey: String,
        @Query("region") region: String
    ): Response<MovieDbResult>

    */

 
    @GET("data/en_US/summoner.json")
    suspend fun getSpells(): Response<SpellsResponseModel>

    @GET("spectator/v4/featured-games")
    suspend fun featuredGamesAsync(@Header("X-Riot-Token") apiKey: String): Response<FeaturedGamesResponse>

    @GET("data/{countryCode}/item.json")
    suspend fun getAllItems(@Path(value="countryCode", encoded=false) countryCode: String): Response<ItemsResponse>

    @GET("data/en_US/champion.json")
    suspend fun getChampions(): Response<ChampionsResponse>

    @GET("summoner/v4/summoners/by-name/{value}")
    suspend fun getSummoner(@Path("value") summonerName: String, @Header("X-Riot-Token") apiKey: String): Response<Summoner>
}