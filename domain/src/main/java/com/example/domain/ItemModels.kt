package com.example.domain

data class ItemsResponse (
    val type: String,
    val version: String,
    val data: Map<Int, Item>
)

data class Item (
    val id: Int,
    val name: String,
    val description: String,
    val plaintext: String,
    val image: Img,
    val gold: Gold
)

data class Img (
    val full: String,
    val sprite: String,
    val x: Long,
    val y: Long,
    val w: Long,
    val h: Long
)

data class Gold (
    val total: Int,
    val sell: Int
)

