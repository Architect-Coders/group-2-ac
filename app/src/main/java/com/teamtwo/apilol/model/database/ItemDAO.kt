package com.teamtwo.apilol.model.database

import androidx.room.*
import com.teamtwo.apilol.model.database.entities.ItemEntity

@Dao
interface ItemDAO {

    @Insert
    fun insertItem(item: ItemEntity)

    @Query("SELECT * FROM ItemEntity")
    fun getAllItems(): List<ItemEntity>

    @Query("SELECT * FROM itementity WHERE id = :id")
    fun getByIdItem(id: Int): List<ItemEntity>

    @Update
    fun updateItem(item: ItemEntity)

    @Delete
    fun deleteItem(item: ItemEntity)
}