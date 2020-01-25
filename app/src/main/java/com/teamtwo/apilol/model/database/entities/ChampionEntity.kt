package com.teamtwo.apilol.model.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.Image
import com.example.domain.Info
import com.example.domain.Stats

@Entity
data class ChampionEntity(
    val version: String,
    @PrimaryKey val id: String,
    val key: String,
    val name: String,
    val title: String,
    val blurb: String,
    val info: Info,
    val image: Image,
    val partype: String,
    val stats: Stats,
    val favourite: Boolean
)
