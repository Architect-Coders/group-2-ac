package com.teamtwo.apilol.model.database.entities.items

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ImageEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val full: String,
    val sprite: String,
    val x: Long,
    val y: Long,
    val w: Long,
    val h: Long
)