package com.teamtwo.apilol.model.items

import com.example.domain.Item
import com.teamtwo.apilol.model.database.entities.ItemEntity

fun ItemEntity.toItemDomain(): Item = Item(
    id,
    name,
    description,
    plaintext,
    image,
    gold
)

fun Item.toItemEntity(): ItemEntity =
    ItemEntity(
        id,
        name,
        description,
        plaintext,
        image,
        gold
    )