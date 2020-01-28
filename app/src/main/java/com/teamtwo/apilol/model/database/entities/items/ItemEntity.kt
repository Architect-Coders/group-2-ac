package com.teamtwo.apilol.model.database.entities.items

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.teamtwo.apilol.model.database.entities.items.GoldEntity
import com.teamtwo.apilol.model.database.entities.items.ImageEntity

@Entity
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val description: String,
    val plaintext: String, //ShortDescription
    val image_id: Int,
    val gold_id: Int,
    val tags: String,
    val stats: String
)