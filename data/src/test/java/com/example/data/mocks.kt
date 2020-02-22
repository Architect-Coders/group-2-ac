package com.example.data

import com.example.domain.FeaturedGameInfo
import com.example.domain.Observer
import com.example.domain.Champion
import com.example.domain.Image
import com.example.domain.Info
import com.example.domain.Stats

val localMatch = FeaturedGameInfo(
    0L,
    0L,
    "",
    "",
    0L,
    "",
    emptyList(),
    Observer(""),
    emptyList(),
    0L,
    null
)

val localChampion = Champion(
    "id",
    "",
    "",
    "",
    "",
    "",
    Info(0L,0L,0L,0L),
    Image("", "", 0L, 0L, 0L, 0L),
    "",
    Stats(0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0),
    false
)