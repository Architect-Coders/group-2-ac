package com.teamtwo.apilol.model.champions

data class ChampionsResponse (
    val type: String,
    val format: String,
    val version: String,
    val data: Map<String, Champion>
)

data class Champion (
    val version: String,
    val id: String,
    val key: String,
    val name: String,
    val title: String,
    val blurb: String,
    val info: Info,
    val image: Image,
    val tags: List<Tag>,
    val partype: Partype,
    val stats: Map<String, Double>
)

data class Image (
    val full: String,
    val sprite: String,
    val x: Long,
    val y: Long,
    val w: Long,
    val h: Long
)

data class Info (
    val attack: Long,
    val defense: Long,
    val magic: Long,
    val difficulty: Long
)

enum class Partype {
    BloodWell,
    Courage,
    CrimsonRush,
    Energy,
    Ferocity,
    Flow,
    Fury,
    Heat,
    Mana,
    None,
    Rage,
    Shield
}

enum class Tag {
    Assassin,
    Fighter,
    Mage,
    Marksman,
    Support,
    Tank
}
