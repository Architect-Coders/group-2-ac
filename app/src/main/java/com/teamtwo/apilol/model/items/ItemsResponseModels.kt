package com.teamtwo.apilol.model.items

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class ItemsResponse (
    val type: String,
    val version: String,
    val data: Map<Int, Item>,
    val tree: Map<Int,Tree>
)

@Parcelize
data class Item (
    val name: String,
    val description: String,
    val plaintext: String, //ShortDescription
    val into: Array<Int>, //Upgrade item
    val image: Image,
    val gold: Gold,
    val tags: Array<String>,
    val stats: Map<String,Int>

) : Parcelable

@Parcelize
data class Image (
    val full: String,
    val sprite: String,
    val x: Long,
    val y: Long,
    val w: Long,
    val h: Long
) : Parcelable

@Parcelize
data class Gold (
  val total: Int,
  val sell: Int
) :Parcelable

@Parcelize
data class Tree (
    val header: String,
    val tags: Array<String>
) : Parcelable