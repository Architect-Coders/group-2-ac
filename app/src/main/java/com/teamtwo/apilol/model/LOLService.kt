package com.teamtwo.apilol.model

import com.teamtwo.apilol.matches.FeaturedGamesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

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
}