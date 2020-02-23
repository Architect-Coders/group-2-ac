package com.teamtwo.apilol.model.spells

import com.example.domain.*
import com.teamtwo.apilol.model.database.entities.SpellsEntity


fun SpellsEntity.toDomain(): Spell = Spell(
    id,
    name,
    description,
    tooltip,
    maxrank,
    costType,
    image,
    resource
)

fun Spell.toEntity(): SpellsEntity = SpellsEntity(
    id,
    name,
    description,
    tooltip,
    maxrank,
    costType,
    image,
    resource
)

