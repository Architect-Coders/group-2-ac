package com.teamtwo.apilol.model.sumonners

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Summoner (
    val profileIconId: Int,
    val name: String,
    val summonerLevel: Int,
    val accountId: String,
    val id: String,
    val revisionDate: Long
): Parcelable