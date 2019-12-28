package com.teamtwo.apilol.model.spells

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class SpellsResponseModel (

    val type : String,
    val version: String,
    val data : Map<String, Spell>
)

@Parcelize
data class Spell(
    val id : String,
    val name : String,
    val description : String,
    val tooltip : String,
    val maxrank : Int,
    val cooldown : List<Double>,
    val cooldownBurn : Double,
    val cost : List<Int>,
    val costBurn : Int,
    val effectBurn : List<String>,
    val vars : List<Vars>,
    val key : Int,
    val summonerLevel : Int,
    val modes : List<String>,
    val costType : String,
    val maxammo : Int,
    val range : List<Int>,
    val rangeBurn : Int,
    val image : Image,
    val resource : String

) : Parcelable


@Parcelize
data class Image (

    val full : String,
    val sprite : String,
    val group : String,
    val x : Int,
    val y : Int,
    val w : Int,
    val h : Int
): Parcelable

@Parcelize
data class Vars (

    val link : String,
    val key : String
):Parcelable