package com.teamtwo.apilol.model.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.Gold
import com.example.domain.Img

@Entity
data class ItemEntity(
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    val name: String,
    val description: String,
    val plaintext: String,
    val image: Img,
    val gold: Gold
)