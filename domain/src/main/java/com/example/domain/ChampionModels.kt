package com.example.domain

data class ChampionsResponse (
    val type: String,
    val format: String,
    val version: String,
    val data: Map<String, Champion>
)

data class Champion(
    val id: String,
    val version: String,
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

data class Stats (
    val hp: Double,
    val hpperlevel: Double,
    val mp: Double,
    val mpperlevel: Double,
    val movespeed: Double,
    val armor: Double,
    val armorperlevel: Double,
    val spellblock: Double,
    val spellblockperlevel: Double,
    val attackrange: Double,
    val hpregen: Double,
    val hpregenperlevel: Double,
    val mpregen: Double,
    val mpregenperlevel: Double,
    val crit: Double,
    val critperlevel: Double,
    val attackdamage: Double,
    val attackdamageperlevel: Double,
    val attackspeedperlevel: Double,
    val attackspeed: Double
)
