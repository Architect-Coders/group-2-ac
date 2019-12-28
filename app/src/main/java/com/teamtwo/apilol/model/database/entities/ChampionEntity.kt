package com.teamtwo.apilol.model.database.entities

import androidx.room.Entity

@Entity
data class ChampionEntity(
    val version: String,
    val id: String,
    val key: String,
    val name: String,
    val title: String,
    val blurb: String,
    val info: String,
    val image: String,
    val tags: String,
    val partype: String,
    val stats: String
)
