package com.teamtwo.apilol.model.database

import androidx.room.*
import com.teamtwo.apilol.model.database.entities.items.ItemEntity

@Dao
interface ItemDAO {

    @Insert
    fun insert(item: ItemEntity)

    @Query("SELECT * FROM itementity WHERE id = :id")
    fun getById(id: Int): List<ItemEntity>

    @Update
    fun update(item: ItemEntity)

    @Delete
    fun delete(item: ItemEntity)
}