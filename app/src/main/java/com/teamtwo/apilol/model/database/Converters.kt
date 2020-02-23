package com.teamtwo.apilol.model.database

import androidx.room.TypeConverter
import com.example.domain.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


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

    @TypeConverter
    fun fromBannedChampions(champions: List<BannedChampion>): String = Gson().toJson(champions)

    @TypeConverter
    fun toBannedChampions(champions: String): List<BannedChampion> =
        Gson().fromJson(champions, object: TypeToken<List<BannedChampion>>() {}.type)

    @TypeConverter
    fun fromObserver (observer: Observer): String = Gson().toJson(observer)

    @TypeConverter
    fun toObserver (observer: String): Observer = Gson().fromJson(observer, Observer::class.java)

    @TypeConverter
    fun fromParticipants(participants: List<Participant>): String = Gson().toJson(participants)

    @TypeConverter
    fun toParticipants(participants: String): List<Participant> =
        Gson().fromJson(participants, object: TypeToken<List<Participant>>() {}.type)

    @TypeConverter
    fun fromQueue (queue: Queue): String = Gson().toJson(queue)

    @TypeConverter
    fun toQueue (queue: String): Queue = Gson().fromJson(queue, Queue::class.java)


    @TypeConverter
    fun toImg(image: String): Img = Gson().fromJson(image, Img::class.java)

    @TypeConverter
    fun fromImg(image: Img): String = Gson().toJson(image)

    @TypeConverter
    fun toGold(gold: String): Gold = Gson().fromJson(gold, Gold::class.java)

    @TypeConverter
    fun fromGold(gold: Gold): String = Gson().toJson(gold)
}