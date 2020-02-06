package com.teamtwo.apilol.model.database

import androidx.room.*
import com.teamtwo.apilol.model.database.entities.ChampionEntity
import com.teamtwo.apilol.model.database.entities.MatchesEntity

@Dao
interface ApilolDAO {

    /*
    
    Examples

    @Query("SELECT * FROM Movie")
    fun getAll(): List<Movie>

    @Query("SELECT * FROM Movie WHERE id = :id")
    fun findById(id: Int): Movie

    @Query("SELECT COUNT(id) FROM Movie")
    fun movieCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovies(movies: List<Movie>)

    @Update
    fun updateMovie(movie: Movie)

    */

    //Champions
    @Query("SELECT * FROM ChampionEntity")
    fun getAllChampions(): List<ChampionEntity>

    @Query("SELECT COUNT(id) FROM ChampionEntity")
    fun numberOfChampions(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertChampions(championList: List<ChampionEntity>)

    @Query("SELECT * FROM ChampionEntity WHERE id = :id")
    fun findChampionById(id: String): ChampionEntity

    @Update
    fun updateChampion(champion: ChampionEntity)

    //Matches
    @Query("SELECT * FROM MatchesEntity")
    fun getOldMatches(): List<MatchesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMatches(matches: List<MatchesEntity>)

    @Query("SELECT COUNT(gameId) FROM MatchesEntity")
    fun countMatches(): Int

}