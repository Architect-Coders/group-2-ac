package com.teamtwo.apilol.model.database

import androidx.room.TypeConverter
import com.example.domain.*
import com.google.gson.Gson


class Converters {

    @TypeConverter
    fun toInfo(info: String): Info = Gson().fromJson(info, Info::class.java)

    @TypeConverter
    fun formInfo(info: Info): String = Gson().toJson(info)

    @TypeConverter
    fun toImage(image: String): Image = Gson().fromJson(image, Image::class.java)

    @TypeConverter
    fun fromImage(info: Image): String = Gson().toJson(info)

    @TypeConverter
    fun toStats(stats: String): Stats = Gson().fromJson(stats, Stats::class.java)

    @TypeConverter
    fun fromStats(stats: Stats): String = Gson().toJson(stats)

    @TypeConverter
    fun toImg(image: String): Img = Gson().fromJson(image, Img::class.java)

    @TypeConverter
    fun fromImg(image: Img): String = Gson().toJson(image)

    @TypeConverter
    fun toGold(gold: String): Gold = Gson().fromJson(gold, Gold::class.java)

    @TypeConverter
    fun fromGold(gold: Gold): String = Gson().toJson(gold)
}