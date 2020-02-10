package com.teamtwo.apilol.model.database

import androidx.room.*
import com.example.domain.Spell
import com.teamtwo.apilol.model.database.entities.ChampionEntity
import com.teamtwo.apilol.model.database.entities.SpellsEntity

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



    //Spell
    @Query("SELECT * FROM SpellsEntity")
    fun getSpells(): List<SpellsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSpells(spells: List<SpellsEntity>)

    @Query ("SELECT  COUNT(id) FROM SpellsEntity")
    fun isSpellsEmpty(): Int

}