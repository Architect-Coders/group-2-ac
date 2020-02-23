package com.teamtwo.apilol.model.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.ImageS

@Entity
data class SpellsEntity (
    @PrimaryKey val id: String,
    val name: String,
    val description: String,
    val tooltip: String,
    val maxrank: Int,
    val costType: String,
    val image: ImageS,
    val resource: String
)