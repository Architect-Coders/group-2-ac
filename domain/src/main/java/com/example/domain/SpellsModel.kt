package com.example.domain


data class SpellsResponseModel(

    val type: String,
    val version: String,
    val data: Map<String, Spell>
)

data class Spell(
    val id: String,
    val name: String,
    val description: String,
    val tooltip: String,
    val maxrank: Int,
    val costType: String,
    val image: ImageS,
    val resource: String

)


data class ImageS(

    val full: String,
    val sprite: String,
    val group: String,
    val x: Int,
    val y: Int,
    val w: Int,
    val h: Int
)

