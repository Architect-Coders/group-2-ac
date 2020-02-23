package com.teamtwo.apilol.model.database

import androidx.room.*
import com.teamtwo.apilol.model.database.entities.ChampionEntity
import com.teamtwo.apilol.model.database.entities.ItemEntity
import com.teamtwo.apilol.model.database.entities.SpellsEntity
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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertChampions(championList: List<ChampionEntity>)

    @Query("SELECT * FROM ChampionEntity WHERE id = :id")
    fun findChampionById(id: String): ChampionEntity

    @Update
    fun updateChampion(champion: ChampionEntity)

    @Insert
    fun insertItem(item: List<ItemEntity>)

    @Query("SELECT * FROM ItemEntity")
    fun getAllItems(): List<ItemEntity>

    @Query("SELECT * FROM ItemEntity WHERE id = :id")
    fun getItemById(id: String): ItemEntity

    @Query("SELECT COUNT(id) FROM ItemEntity")
    fun getItemsRecordCount(): Int

    @Update
    fun updateItem(item: ItemEntity)

    @Delete
    fun deleteItem(item: ItemEntity)



    //Spell
    @Query("SELECT * FROM SpellsEntity")
    fun getSpells(): List<SpellsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSpells(spells: List<SpellsEntity>)

    @Query ("SELECT  COUNT(id) FROM SpellsEntity")
    fun isSpellsEmpty(): Int

    //Matches
    @Query("SELECT * FROM MatchesEntity ORDER BY gameId DESC LIMIT 20")
    fun getOldMatches(): List<MatchesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMatches(matches: List<MatchesEntity>)

    @Query("SELECT COUNT(gameId) FROM MatchesEntity")
    fun countMatches(): Int

}