package com.teamtwo.apilol.model.champions

import com.example.domain.Champion
import com.teamtwo.apilol.model.database.entities.ChampionEntity

fun ChampionEntity.toChampionDomain(): Champion = Champion(
    id,
    version,
    key,
    name,
    title,
    blurb,
    info,
    image,
    partype,
    stats,
    favourite
)

fun Champion.toChampionEntity(): ChampionEntity = ChampionEntity(
    id,
    version,
    key,
    name,
    title,
    blurb,
    info,
    image,
    partype,
    stats,
    favourite
)