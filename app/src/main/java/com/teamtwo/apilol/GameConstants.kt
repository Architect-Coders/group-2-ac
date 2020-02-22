package com.teamtwo.apilol

import android.os.Parcelable
import com.example.domain.Queue
import kotlinx.android.parcel.Parcelize

object Seasons {

    const val PRESEASON_3 = 0
    const val SEASON_3 = 1
    const val PRESEASON_2014 = 2
    const val SEASON_2014 = 3
    const val PRESEASON_2015 = 4
    const val SEASON_2015 = 5
    const val PRESEASON_2016 = 6
    const val SEASON_2016 = 7
    const val PRESEASON_2017 = 8
    const val SEASON_2017 = 9
    const val PRESEASON_2018 = 10
    const val SEASON_2018 = 11
    const val PRESEASON_2019 = 12
    const val SEASON_2019 = 13
}

object Queues {

    val QUEUE_LIST = listOf (
        Queue (0, "Custom games", null, null),
        Queue (2, "Summoner's Rift", "5v5 Blind Pick games", "Deprecated in patch 7.19 in favor of queueId 430"),
        Queue (4, "Summoner's Rift", "5v5 Ranked Solo games", "Deprecated in favor of queueId 420"),
        Queue (6, "Summoner's Rift", "5v5 Ranked Premade games", "Game mode deprecated"),
        Queue (7, "Summoner's Rift", "Co-op vs AI games", "Deprecated in favor of queueId 32 and 33"),
        Queue (8, "Twisted Treeline","3v3 Normal games","Deprecated in patch 7.19 in favor of queueId 460"),
        Queue (9, "Twisted Treeline", "3v3 Ranked Flex games", "Deprecated in patch 7.19 in favor of queueId 470"),
        Queue (14, "Summoner's Rift", "5v5 Draft Pick games", "Deprecated in favor of queueId 400"),
        Queue (16, "Crystal Scar", "5v5 Dominion Blind Pick games", "Game mode deprecated"),
        Queue (17, "Crystal Scar", "5v5 Dominion Draft Pick games", "Game mode deprecated"),
        Queue (25, "Crystal Scar", "Dominion Co-op vs AI games", "Game mode deprecated"),
        Queue (31, "Summoner's Rift", "Co-op vs AI Intro Bot games", "Deprecated in patch 7.19 in favor of queueId 830"),
        Queue (31, "Summoner's Rift", "Co-op vs AI Beginner Bot games", "Deprecated in patch 7.19 in favor of queueId 840"),
        Queue (33, "Summoner's Rift", "Co-op vs AI Intermediate Bot games", "Deprecated in patch 7.19 in favor of queueId 850"),
        Queue (41, "Twisted Treeline", "3v3 Ranked Team games", "Game mode deprecated"),
        Queue (42, "Summoner's Rift", "5v5 Ranked Team games", "Game mode deprecated"),
        Queue (52, "Twisted Treeline", "Co-op vs AI games", "Deprecated in patch 7.19 in favor of queueId 800"),
        Queue (61, "Summoner's Rift", "5v5 Team Builder games", "Game mode deprecated"),
        Queue (65, "Howling Abyss", "5v5 ARAM games", "Deprecated in patch 7.19 in favor of queueId 450"),
        Queue (67, "Howling Abyss", "ARAM Co-op vs AI games", "Game mode deprecated"),
        Queue (70, "Summoner's Rift", "One for All games", "Deprecated in patch 8.6 in favor of queueId 1020"),
        Queue (72, "Howling Abyss", "1v1 Snowdown Showdown games", null),
        Queue (73, "Howling Abyss", "2v2 Snowdown Showdown games", null),
        Queue (75, "Summoner's Rift", "6v6 Hexakill games", null),
        Queue (76, "Summoner's Rift", "Ultra Rapid Fire games", null),
        Queue (78, "Howling Abyss", "One For All: Mirror Mode games", null),
        Queue (83, "Summoner's Rift", "Co-op vs AI Ultra Rapid Fire games", null),
        Queue (91, "Summoner's Rift", "Doom Bots Rank 1 games", "Deprecated in patch 7.19 in favor of queueId 950"),
        Queue (92, "Summoner's Rift", "Doom Bots Rank 2 games", "Deprecated in patch 7.19 in favor of queueId 950"),
        Queue (93, "Summoner's Rift", "Doom Bots Rank 5 games", "Deprecated in patch 7.19 in favor of queueId 950"),
        Queue (96, "Crystal Scar", "Ascension games", "Deprecated in patch 7.19 in favor of queueId 910"),
        Queue (98, "Twisted Treeline", "6v6 Hexakill games", null),
        Queue (100, "Butcher's Bridge", "5v5 ARAM games", null),
        Queue (300, "Howling Abyss", "Legend of the Poro King games", "Deprecated in patch 7.19 in favor of queueId 920"),
        Queue (310, "Summoner's Rift", "Nemesis games", null),
        Queue (313, "Summoner's Rift", "Black Market Brawlers games", null),
        Queue (315, "Summoner's Rift", "Nexus Siege games", "Deprecated in patch 7.19 in favor of queueId 940"),
        Queue (317, "Crystal Scar", "Definitely Not Dominion games", null),
        Queue (318, "Summoner's Rift", "ARURF games", "Deprecated in patch 7.19 in favor of queueId 900"),
        Queue (325, "Summoner's Rift", "All Random games", null),
        Queue (400, "Summoner's Rift", "5v5 Draft Pick games", null),
        Queue (410, "Summoner's Rift", "5v5 Ranked Dynamic games", "Game mode deprecated in patch 6.22"),
        Queue (420, "Summoner's Rift", "5v5 Ranked Solo games", null),
        Queue (430, "Summoner's Rift", "5v5 Blind Pick games", null),
        Queue (440, "Summoner's Rift", "5v5 Ranked Flex games", null),
        Queue (450, "Howling Abyss", "5v5 ARAM games", null),
        Queue (460, "Twisted Treeline", "3v3 Blind Pick games", null),
        Queue (470, "Twisted Treeline", "3v3 Ranked Flex games", null),
        Queue (600, "Summoner's Rift", "Blood Hunt Assassin games", null),
        Queue (610, "Cosmic Ruins", "Dark Star: Singularity games", null),
        Queue (700, "Summoner's Rift", "Clash games", null),
        Queue (800, "Twisted Treeline", "Co-op vs. AI Intermediate Bot games", null),
        Queue (810, "Twisted Treeline", "Co-op vs. AI Intro Bot games", null),
        Queue (820, "Twisted Treeline", "Co-op vs. AI Beginner Bot games", null),
        Queue (830, "Summoner's Rift", "Co-op vs. AI Intro Bot games", null),
        Queue (840, "Summoner's Rift", "Co-op vs. AI Beginner Bot games", null),
        Queue (850, "Summoner's Rift", "Co-op vs. AI Intermediate Bot games", null),
        Queue (900, "Summoner's Rift", "URF games", null),
        Queue (910, "Crystal Scar", "Ascension games", null),
        Queue (920, "Howling Abyss", "Legend of the Poro King games", null),
        Queue (940, "Summoner's Rift", "Nexus Siege games", null),
        Queue (950, "Summoner's Rift", "Doom Bots Voting games", null),
        Queue (960, "Summoner's Rift", "Doom Bots Standard games", null),
        Queue (980, "Valoran City Park", "Star Guardian Invasion: Normal games", null),
        Queue (990, "Valoran City Park", "Star Guardian Invasion: Onslaught games", null),
        Queue (1000, "Overcharge", "PROJECT: Hunters games", null),
        Queue (1010, "Summoner's Rift", "Snow ARURF games", null),
        Queue (1020, "Summoner's Rift", "One for All games", null),
        Queue (1030, "Crash Site", "Odyssey Extraction: Intro games", null),
        Queue (1040, "Crash Site", "Odyssey Extraction: Cadet games", null),
        Queue (1050, "Crash Site", "Odyssey Extraction: Crewmember games", null),
        Queue (1060, "Crash Site", "Odyssey Extraction: Captain games", null),
        Queue (1070, "Crash Site", "Odyssey Extraction: Onslaught games", null),
        Queue (1090, "Convergence", "Teamfight Tactics games", null),
        Queue (1100, "Convergence", "Ranked Teamfight Tactics games", null),
        Queue (1200, "Nexus Blitz", "Nexus Blitz games", "Deprecated in patch 9.2"),
        Queue (2000, "Summoner's Rift", "Tutorial 1", null),
        Queue (2010, "Summoner's Rift", "Tutorial 2", null),
        Queue (2020, "Summoner's Rift", "Tutorial 3", null)
    )
}



object Maps {
    const val SUMMONERS_RIFT_SUMMER = 1
    const val SUMMONERS_RIFT_AUTUMN = 2
    const val PROVING_GROUNDS = 3
    const val TWISTED_TREELINE_ORIGINAL = 4
    const val CRYSTAL_SCAR = 8
    const val TWISTED_TREELINE_LAST = 10
    const val SUMMONERS_RIFT = 11
    const val HOWLING_ABYSS = 12
    const val BUTCHERS_BRIDGE = 14
    const val COSMIC_RUINS = 16
    const val VALORAN_CITY_PARK = 18
    const val SUBSTRUCTURE_43 = 19
    const val CRASH_SITE = 20
    const val NEXUS_BLITZ = 21
}

object GameModes {
    const val CLASSIC = "CLASSIC"
    const val ODIN = "ODIN"
    const val ARAM = "ARAM"
    const val TUTORIAL = "TUTORIAL"
    const val URF = "URF"
    const val DOOMBOTSTEEMO = "DOOMBOTSTEEMO"
    const val ONEFORALL = "ONEFORALL"
    const val ASCENSION = "ASCENSION"
    const val FIRSTBLOOD = "FIRSTBLOOD"
    const val KINGPORO = "KINGPORO"
    const val SIEGE = "SIEGE"
    const val ASSASSINATE = "ASSASSINATE"
    const val ARSR = "ARSR"
    const val DARKSTAR = "DARKSTAR"
    const val STARGUARDIAN = "STARGUARDIAN"
    const val PROJECT = "PROJECT"
    const val GAMEMODEX = "GAMEMODEX"
    const val ODYSSEY = "ODYSSEY"
}

object GameTypes {
    const val CUSTOM_GAME = "CUSTOM_GAME"
    const val TUTORIAL_GAME = "TUTORIAL_GAME"
    const val MATCHED_GAME = "MATCHED_GAME"
}