package com.teamtwo.apilol.model.database

import androidx.room.TypeConverter
import com.example.domain.Image
import com.example.domain.ImageS
import com.example.domain.Info
import com.example.domain.Stats
import com.google.gson.Gson


class Converters {

    @TypeConverter
    fun toInfo(info: String): Info = Gson().fromJson(info, Info::class.java)

    @TypeConverter
    fun formInfo(info: Info): String = Gson().toJson(info)

    @TypeConverter
    fun toImage(image: String): Image = Gson().fromJson(image, Image::class.java)

    @TypeConverter
    fun toImageS(image: String): ImageS = Gson().fromJson(image, ImageS::class.java)

    @TypeConverter
    fun fromImageS(info: ImageS): String = Gson().toJson(info)

    @TypeConverter
    fun fromImage(info: Image): String = Gson().toJson(info)

    @TypeConverter
    fun toStats(stats: String): Stats = Gson().fromJson(stats, Stats::class.java)

    @TypeConverter
    fun fromStats(stats: Stats): String = Gson().toJson(stats)
}