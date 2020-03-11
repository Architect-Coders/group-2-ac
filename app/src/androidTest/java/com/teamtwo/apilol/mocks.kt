package com.teamtwo.apilol

val championListMock = """
    {
      "type": "champion",
      "format": "standAloneComplex",
      "version": "9.23.1",
      "data": {
        "Aatrox": {
          "version": "9.23.1",
          "id": "Aatrox",
          "key": "266",
          "name": "Aatrox",
          "title": "the Darkin Blade",
          "blurb": "Once honored defenders of Shurima against the Void, Aatrox and his brethren would eventually become an even greater threat to Runeterra, and were defeated only by cunning mortal sorcery. But after centuries of imprisonment, Aatrox was the first to find...",
          "info": {
            "attack": 8,
            "defense": 4,
            "magic": 3,
            "difficulty": 4
          },
          "image": {
            "full": "Aatrox.png",
            "sprite": "champion0.png",
            "group": "champion",
            "x": 0,
            "y": 0,
            "w": 48,
            "h": 48
          },
          "tags": [
            "Fighter",
            "Tank"
          ],
          "partype": "Blood Well",
          "stats": {
            "hp": 580,
            "hpperlevel": 90,
            "mp": 0,
            "mpperlevel": 0,
            "movespeed": 345,
            "armor": 38,
            "armorperlevel": 3.25,
            "spellblock": 32.1,
            "spellblockperlevel": 1.25,
            "attackrange": 175,
            "hpregen": 3,
            "hpregenperlevel": 1,
            "mpregen": 0,
            "mpregenperlevel": 0,
            "crit": 0,
            "critperlevel": 0,
            "attackdamage": 60,
            "attackdamageperlevel": 5,
            "attackspeedperlevel": 2.5,
            "attackspeed": 0.651
          }
        },
        "Ahri": {
          "version": "9.23.1",
          "id": "Ahri",
          "key": "103",
          "name": "Ahri",
          "title": "the Nine-Tailed Fox",
          "blurb": "Innately connected to the latent power of Runeterra, Ahri is a vastaya who can reshape magic into orbs of raw energy. She revels in toying with her prey by manipulating their emotions before devouring their life essence. Despite her predatory nature...",
          "info": {
            "attack": 3,
            "defense": 4,
            "magic": 8,
            "difficulty": 5
          },
          "image": {
            "full": "Ahri.png",
            "sprite": "champion0.png",
            "group": "champion",
            "x": 48,
            "y": 0,
            "w": 48,
            "h": 48
          },
          "tags": [
            "Mage",
            "Assassin"
          ],
          "partype": "Mana",
          "stats": {
            "hp": 526,
            "hpperlevel": 92,
            "mp": 418,
            "mpperlevel": 25,
            "movespeed": 330,
            "armor": 20.88,
            "armorperlevel": 3.5,
            "spellblock": 30,
            "spellblockperlevel": 0.5,
            "attackrange": 550,
            "hpregen": 6.5,
            "hpregenperlevel": 0.6,
            "mpregen": 8,
            "mpregenperlevel": 0.8,
            "crit": 0,
            "critperlevel": 0,
            "attackdamage": 53.04,
            "attackdamageperlevel": 3,
            "attackspeedperlevel": 2,
            "attackspeed": 0.668
          }
        },
        "Akali": {
          "version": "9.23.1",
          "id": "Akali",
          "key": "84",
          "name": "Akali",
          "title": "the Rogue Assassin",
          "blurb": "Abandoning the Kinkou Order and her title of the Fist of Shadow, Akali now strikes alone, ready to be the deadly weapon her people need. Though she holds onto all she learned from her master Shen, she has pledged to defend Ionia from its enemies, one...",
          "info": {
            "attack": 5,
            "defense": 3,
            "magic": 8,
            "difficulty": 7
          },
          "image": {
            "full": "Akali.png",
            "sprite": "champion0.png",
            "group": "champion",
            "x": 96,
            "y": 0,
            "w": 48,
            "h": 48
          },
          "tags": [
            "Assassin"
          ],
          "partype": "Energy",
          "stats": {
            "hp": 575,
            "hpperlevel": 95,
            "mp": 200,
            "mpperlevel": 0,
            "movespeed": 345,
            "armor": 23,
            "armorperlevel": 3.5,
            "spellblock": 37,
            "spellblockperlevel": 1.25,
            "attackrange": 125,
            "hpregen": 8,
            "hpregenperlevel": 0.5,
            "mpregen": 50,
            "mpregenperlevel": 0,
            "crit": 0,
            "critperlevel": 0,
            "attackdamage": 62.4,
            "attackdamageperlevel": 3.3,
            "attackspeedperlevel": 3.2,
            "attackspeed": 0.625
          }
        },
        "Alistar": {
          "version": "9.23.1",
          "id": "Alistar",
          "key": "12",
          "name": "Alistar",
          "title": "the Minotaur",
          "blurb": "Always a mighty warrior with a fearsome reputation, Alistar seeks revenge for the death of his clan at the hands of the Noxian empire. Though he was enslaved and forced into the life of a gladiator, his unbreakable will was what kept him from truly...",
          "info": {
            "attack": 6,
            "defense": 9,
            "magic": 5,
            "difficulty": 7
          },
          "image": {
            "full": "Alistar.png",
            "sprite": "champion0.png",
            "group": "champion",
            "x": 144,
            "y": 0,
            "w": 48,
            "h": 48
          },
          "tags": [
            "Tank",
            "Support"
          ],
          "partype": "Mana",
          "stats": {
            "hp": 573.36,
            "hpperlevel": 106,
            "mp": 350,
            "mpperlevel": 40,
            "movespeed": 330,
            "armor": 44,
            "armorperlevel": 3.5,
            "spellblock": 32.1,
            "spellblockperlevel": 1.25,
            "attackrange": 125,
            "hpregen": 8.5,
            "hpregenperlevel": 0.85,
            "mpregen": 8.5,
            "mpregenperlevel": 0.8,
            "crit": 0,
            "critperlevel": 0,
            "attackdamage": 61.1116,
            "attackdamageperlevel": 3.62,
            "attackspeedperlevel": 2.125,
            "attackspeed": 0.625
          }
        }
      }
    }
""".trimIndent()

val matchesListMock = """
    {
        "gameList": [
            {
                "gameId": 4438631463,
                "mapId": 12,
                "gameMode": "ARAM",
                "gameType": "MATCHED_GAME",
                "gameQueueConfigId": 450,
                "participants": [
                    {
                        "teamId": 100,
                        "spell1Id": 32,
                        "spell2Id": 4,
                        "championId": 12,
                        "profileIconId": 663,
                        "summonerName": "Iraee",
                        "bot": false
                    },
                    {
                        "teamId": 100,
                        "spell1Id": 32,
                        "spell2Id": 4,
                        "championId": 157,
                        "profileIconId": 3584,
                        "summonerName": "Zoe best waifu",
                        "bot": false
                    },
                    {
                        "teamId": 100,
                        "spell1Id": 4,
                        "spell2Id": 32,
                        "championId": 120,
                        "profileIconId": 750,
                        "summonerName": "Needally",
                        "bot": false
                    },
                    {
                        "teamId": 100,
                        "spell1Id": 4,
                        "spell2Id": 32,
                        "championId": 245,
                        "profileIconId": 1297,
                        "summonerName": "Piak1204",
                        "bot": false
                    },
                    {
                        "teamId": 100,
                        "spell1Id": 32,
                        "spell2Id": 4,
                        "championId": 25,
                        "profileIconId": 4027,
                        "summonerName": "SBOLBACK",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 32,
                        "spell2Id": 4,
                        "championId": 90,
                        "profileIconId": 4490,
                        "summonerName": "Ro Nal Doe",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 4,
                        "spell2Id": 32,
                        "championId": 350,
                        "profileIconId": 3587,
                        "summonerName": "Moeisonice",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 4,
                        "spell2Id": 32,
                        "championId": 131,
                        "profileIconId": 745,
                        "summonerName": "Boah der Damage",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 32,
                        "spell2Id": 4,
                        "championId": 59,
                        "profileIconId": 3013,
                        "summonerName": "Neophyte",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 4,
                        "spell2Id": 7,
                        "championId": 119,
                        "profileIconId": 683,
                        "summonerName": "MÄÄHX",
                        "bot": false
                    }
                ],
                "observers": {
                    "encryptionKey": "aakEBsagSW+BNsTAilAJP8GMtEXsMn8u"
                },
                "platformId": "EUW1",
                "bannedChampions": [],
                "gameStartTime": 1583304871700,
                "gameLength": 368
            },
            {
                "gameId": 4438701510,
                "mapId": 11,
                "gameMode": "CLASSIC",
                "gameType": "MATCHED_GAME",
                "gameQueueConfigId": 420,
                "participants": [
                    {
                        "teamId": 100,
                        "spell1Id": 11,
                        "spell2Id": 4,
                        "championId": 5,
                        "profileIconId": 1298,
                        "summonerName": "Zoyohoyoz",
                        "bot": false
                    },
                    {
                        "teamId": 100,
                        "spell1Id": 14,
                        "spell2Id": 4,
                        "championId": 7,
                        "profileIconId": 4357,
                        "summonerName": "TRAMA ChoeGo",
                        "bot": false
                    },
                    {
                        "teamId": 100,
                        "spell1Id": 4,
                        "spell2Id": 12,
                        "championId": 150,
                        "profileIconId": 3839,
                        "summonerName": "CE7LEYA",
                        "bot": false
                    },
                    {
                        "teamId": 100,
                        "spell1Id": 7,
                        "spell2Id": 4,
                        "championId": 145,
                        "profileIconId": 3495,
                        "summonerName": "Ψ Φ Φ Φ Ψ",
                        "bot": false
                    },
                    {
                        "teamId": 100,
                        "spell1Id": 4,
                        "spell2Id": 14,
                        "championId": 117,
                        "profileIconId": 7,
                        "summonerName": "2134HJ2U9534ASDG",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 4,
                        "spell2Id": 12,
                        "championId": 518,
                        "profileIconId": 1633,
                        "summonerName": "lllIIIIIIIIIIIl",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 7,
                        "spell2Id": 4,
                        "championId": 81,
                        "profileIconId": 3523,
                        "summonerName": "I Osman",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 4,
                        "spell2Id": 11,
                        "championId": 121,
                        "profileIconId": 4217,
                        "summonerName": "BoogieKing",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 12,
                        "spell2Id": 4,
                        "championId": 41,
                        "profileIconId": 4380,
                        "summonerName": "CAFFEÏNE VICTIM",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 4,
                        "spell2Id": 14,
                        "championId": 497,
                        "profileIconId": 3307,
                        "summonerName": "RL EscøX",
                        "bot": false
                    }
                ],
                "observers": {
                    "encryptionKey": "OMhLct4FLIFvtexQChvKXENtshnDmau7"
                },
                "platformId": "EUW1",
                "bannedChampions": [
                    {
                        "championId": 412,
                        "teamId": 100,
                        "pickTurn": 1
                    },
                    {
                        "championId": 111,
                        "teamId": 100,
                        "pickTurn": 2
                    },
                    {
                        "championId": 30,
                        "teamId": 100,
                        "pickTurn": 3
                    },
                    {
                        "championId": 122,
                        "teamId": 100,
                        "pickTurn": 4
                    },
                    {
                        "championId": 55,
                        "teamId": 100,
                        "pickTurn": 5
                    },
                    {
                        "championId": 875,
                        "teamId": 200,
                        "pickTurn": 6
                    },
                    {
                        "championId": 523,
                        "teamId": 200,
                        "pickTurn": 7
                    },
                    {
                        "championId": 38,
                        "teamId": 200,
                        "pickTurn": 8
                    },
                    {
                        "championId": 111,
                        "teamId": 200,
                        "pickTurn": 9
                    },
                    {
                        "championId": 64,
                        "teamId": 200,
                        "pickTurn": 10
                    }
                ],
                "gameStartTime": 1583305183131,
                "gameLength": 56
            },
            {
                "gameId": 4438631428,
                "mapId": 11,
                "gameMode": "CLASSIC",
                "gameType": "MATCHED_GAME",
                "gameQueueConfigId": 420,
                "participants": [
                    {
                        "teamId": 100,
                        "spell1Id": 7,
                        "spell2Id": 4,
                        "championId": 51,
                        "profileIconId": 3501,
                        "summonerName": "Dad",
                        "bot": false
                    },
                    {
                        "teamId": 100,
                        "spell1Id": 14,
                        "spell2Id": 4,
                        "championId": 267,
                        "profileIconId": 4050,
                        "summonerName": "Saddam Pohuerino",
                        "bot": false
                    },
                    {
                        "teamId": 100,
                        "spell1Id": 11,
                        "spell2Id": 4,
                        "championId": 56,
                        "profileIconId": 3150,
                        "summonerName": "Baby Girl Tree",
                        "bot": false
                    },
                    {
                        "teamId": 100,
                        "spell1Id": 4,
                        "spell2Id": 12,
                        "championId": 61,
                        "profileIconId": 2076,
                        "summonerName": "ragnaroz",
                        "bot": false
                    },
                    {
                        "teamId": 100,
                        "spell1Id": 4,
                        "spell2Id": 12,
                        "championId": 92,
                        "profileIconId": 3494,
                        "summonerName": "Berke mi o",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 12,
                        "spell2Id": 4,
                        "championId": 82,
                        "profileIconId": 665,
                        "summonerName": "Midnight KerWen",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 14,
                        "spell2Id": 4,
                        "championId": 38,
                        "profileIconId": 4026,
                        "summonerName": "Lady of Disaster",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 7,
                        "spell2Id": 4,
                        "championId": 15,
                        "profileIconId": 4132,
                        "summonerName": "TTT Aitlade",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 4,
                        "spell2Id": 11,
                        "championId": 141,
                        "profileIconId": 978,
                        "summonerName": "RYL Sulkirito",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 4,
                        "spell2Id": 14,
                        "championId": 412,
                        "profileIconId": 3592,
                        "summonerName": "Hernando v0",
                        "bot": false
                    }
                ],
                "observers": {
                    "encryptionKey": "pY8YTxiqcB1fldAoPJER3g11hmtlNaQy"
                },
                "platformId": "EUW1",
                "bannedChampions": [
                    {
                        "championId": 523,
                        "teamId": 100,
                        "pickTurn": 1
                    },
                    {
                        "championId": 131,
                        "teamId": 100,
                        "pickTurn": 2
                    },
                    {
                        "championId": 2,
                        "teamId": 100,
                        "pickTurn": 3
                    },
                    {
                        "championId": 24,
                        "teamId": 100,
                        "pickTurn": 4
                    },
                    {
                        "championId": 235,
                        "teamId": 100,
                        "pickTurn": 5
                    },
                    {
                        "championId": 523,
                        "teamId": 200,
                        "pickTurn": 6
                    },
                    {
                        "championId": 875,
                        "teamId": 200,
                        "pickTurn": 7
                    },
                    {
                        "championId": 134,
                        "teamId": 200,
                        "pickTurn": 8
                    },
                    {
                        "championId": 111,
                        "teamId": 200,
                        "pickTurn": 9
                    },
                    {
                        "championId": 69,
                        "teamId": 200,
                        "pickTurn": 10
                    }
                ],
                "gameStartTime": 1583304884601,
                "gameLength": 355
            },
            {
                "gameId": 4438631457,
                "mapId": 12,
                "gameMode": "ARAM",
                "gameType": "MATCHED_GAME",
                "gameQueueConfigId": 450,
                "participants": [
                    {
                        "teamId": 100,
                        "spell1Id": 13,
                        "spell2Id": 4,
                        "championId": 115,
                        "profileIconId": 898,
                        "summonerName": "ł Nib ł",
                        "bot": false
                    },
                    {
                        "teamId": 100,
                        "spell1Id": 4,
                        "spell2Id": 32,
                        "championId": 75,
                        "profileIconId": 3587,
                        "summonerName": "Siralein",
                        "bot": false
                    },
                    {
                        "teamId": 100,
                        "spell1Id": 4,
                        "spell2Id": 32,
                        "championId": 141,
                        "profileIconId": 514,
                        "summonerName": "paXii",
                        "bot": false
                    },
                    {
                        "teamId": 100,
                        "spell1Id": 4,
                        "spell2Id": 32,
                        "championId": 7,
                        "profileIconId": 3860,
                        "summonerName": "ŁŠÐ",
                        "bot": false
                    },
                    {
                        "teamId": 100,
                        "spell1Id": 4,
                        "spell2Id": 32,
                        "championId": 121,
                        "profileIconId": 4494,
                        "summonerName": "vandalmasterV2",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 4,
                        "spell2Id": 32,
                        "championId": 58,
                        "profileIconId": 4279,
                        "summonerName": "Lowbred Lion",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 32,
                        "spell2Id": 14,
                        "championId": 203,
                        "profileIconId": 23,
                        "summonerName": "voiddaek",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 13,
                        "spell2Id": 4,
                        "championId": 16,
                        "profileIconId": 4367,
                        "summonerName": "Tyraelknight",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 4,
                        "spell2Id": 32,
                        "championId": 98,
                        "profileIconId": 780,
                        "summonerName": "Cuadricula",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 4,
                        "spell2Id": 32,
                        "championId": 122,
                        "profileIconId": 4403,
                        "summonerName": "Fijii",
                        "bot": false
                    }
                ],
                "observers": {
                    "encryptionKey": "kkQ6ICtcBoXCdekhRDELwJNpH9WPM68/"
                },
                "platformId": "EUW1",
                "bannedChampions": [],
                "gameStartTime": 1583304830417,
                "gameLength": 409
            },
            {
                "gameId": 4438721487,
                "mapId": 11,
                "gameMode": "CLASSIC",
                "gameType": "MATCHED_GAME",
                "gameQueueConfigId": 420,
                "participants": [
                    {
                        "teamId": 100,
                        "spell1Id": 4,
                        "spell2Id": 11,
                        "championId": 141,
                        "profileIconId": 4463,
                        "summonerName": "Ph1l1pp",
                        "bot": false
                    },
                    {
                        "teamId": 100,
                        "spell1Id": 4,
                        "spell2Id": 7,
                        "championId": 145,
                        "profileIconId": 21,
                        "summonerName": "White Mustang",
                        "bot": false
                    },
                    {
                        "teamId": 100,
                        "spell1Id": 14,
                        "spell2Id": 4,
                        "championId": 111,
                        "profileIconId": 3505,
                        "summonerName": "Jian Guo Wang",
                        "bot": false
                    },
                    {
                        "teamId": 100,
                        "spell1Id": 4,
                        "spell2Id": 14,
                        "championId": 105,
                        "profileIconId": 2089,
                        "summonerName": "PUPUPU",
                        "bot": false
                    },
                    {
                        "teamId": 100,
                        "spell1Id": 12,
                        "spell2Id": 4,
                        "championId": 150,
                        "profileIconId": 527,
                        "summonerName": "Im a motherlover",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 7,
                        "spell2Id": 4,
                        "championId": 67,
                        "profileIconId": 3182,
                        "summonerName": "VAYNE 2020",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 4,
                        "spell2Id": 12,
                        "championId": 54,
                        "profileIconId": 3838,
                        "summonerName": "Phantix",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 14,
                        "spell2Id": 4,
                        "championId": 58,
                        "profileIconId": 4244,
                        "summonerName": "JohnnaTracie",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 4,
                        "spell2Id": 11,
                        "championId": 11,
                        "profileIconId": 1151,
                        "summonerName": "ZOREΝ",
                        "bot": false
                    },
                    {
                        "teamId": 200,
                        "spell1Id": 4,
                        "spell2Id": 14,
                        "championId": 555,
                        "profileIconId": 4079,
                        "summonerName": "Niko1",
                        "bot": false
                    }
                ],
                "observers": {
                    "encryptionKey": "BmJ+qnuSkTSmWySBr1wbRsYsaO8O6mFn"
                },
                "platformId": "EUW1",
                "bannedChampions": [
                    {
                        "championId": 38,
                        "teamId": 100,
                        "pickTurn": 1
                    },
                    {
                        "championId": 89,
                        "teamId": 100,
                        "pickTurn": 2
                    },
                    {
                        "championId": 23,
                        "teamId": 100,
                        "pickTurn": 3
                    },
                    {
                        "championId": 35,
                        "teamId": 100,
                        "pickTurn": 4
                    },
                    {
                        "championId": 142,
                        "teamId": 100,
                        "pickTurn": 5
                    },
                    {
                        "championId": 107,
                        "teamId": 200,
                        "pickTurn": 6
                    },
                    {
                        "championId": 35,
                        "teamId": 200,
                        "pickTurn": 7
                    },
                    {
                        "championId": 25,
                        "teamId": 200,
                        "pickTurn": 8
                    },
                    {
                        "championId": 245,
                        "teamId": 200,
                        "pickTurn": 9
                    },
                    {
                        "championId": 8,
                        "teamId": 200,
                        "pickTurn": 10
                    }
                ],
                "gameStartTime": 1583305170274,
                "gameLength": 69
            }
        ],
        "clientRefreshInterval": 300
    }
""".trimIndent()