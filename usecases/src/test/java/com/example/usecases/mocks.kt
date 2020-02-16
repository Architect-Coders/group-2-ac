package com.example.usecases

import com.example.domain.Champion
import com.example.domain.Image
import com.example.domain.Info
import com.example.domain.Stats
import com.example.domain.FeaturedGameInfo
import com.example.domain.Observer

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