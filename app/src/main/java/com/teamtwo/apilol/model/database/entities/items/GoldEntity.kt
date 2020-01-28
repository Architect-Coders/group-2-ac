package com.teamtwo.apilol.model.database.entities.items

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data
class GoldEntity(
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    val total: Int,
    val sell: Int
)