package com.teamtwo.apilol.model

import retrofit2.Response
import retrofit2.http.GET

interface LOLService {

    /* Architect Codders Example

    @GET("discover/movie?sort_by=popularity.desc")
    suspend fun listPopularMoviesAsync(
        @Query("api_key") apiKey: String,
        @Query("region") region: String
    ): Response<MovieDbResult>

    */

    @GET("data/en_US/champion.json")
    fun getChampions()//: Response<>
}