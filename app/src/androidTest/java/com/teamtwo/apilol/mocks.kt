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

val itemListMock = """
    {
      "type": "item",
      "version": "9.23.1",
      "data": {
        "1": {
          "name": "Botas",
          "description": "Botas basicas",
          "plaintext": "Botas para aumentar velocidad",
          "image": {
            "full": "1001.png",
            "sprite": "item0.png",
            "group": "item",
            "x": 0,
            "y": 0,
            "w": 48,
            "h": 48
          },
          "gold": {
            "total":100,
            "sell":50
          }
        },
        "2": {
          "name": "Botas nuevas",
          "description": "Botas nuevas",
          "plaintext": "Botas para aumentar mucho la velocidad",
          "image": {
            "full": "1004.png",
            "sprite": "item4.png",
            "group": "item",
            "x": 0,
            "y": 0,
            "w": 48,
            "h": 48
          },
          "gold": {
            "total":100,
            "sell":50
          }
        }
      }
    }
""".trimIndent()


val summonerListMock = """
    {
      {"id":"8V0Mkw1Qc-CrOHUErl-VZfGkFXT3-12HsCXMVq1SvbAE",
      "accountId":"5LnXnHQ5nqgGzLw-O-vajgEbH9juFTyInjMkb8nwnWSnyA",
      "puuid":"zCBzxCS5_z6ZoE5Wyjcg4xy93l4EzMpbnUhhLkCGwPizxYBiKLaW97BhAeS26BEzVCHYCMQMct2z3g",
      "name":"Irthael",
      "profileIconId":4270,
      "revisionDate":1582498954000,
      "summonerLevel":63}
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


val spellsListMock ="""{
  "type": "summoner",
  "version": "9.23.1",
  "data": {
    "SummonerBarrier": {
      "id": "SummonerBarrier",
      "name": "Barrier",
      "description": "Shields your champion from 115-455 damage (depending on champion level) for 2 seconds.",
      "tooltip": "Temporarily shields {{ f1 }} damage from your champion for 2 seconds.",
      "maxrank": 1,
      "cooldown": [
        180
      ],
      "cooldownBurn": "180",
      "cost": [
        0
      ],
      "costBurn": "0",
      "datavalues": {},
      "effect": [
        null,
        [
          95
        ],
        [
          20
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ]
      ],
      "effectBurn": [
        null,
        "95",
        "20",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0"
      ],
      "vars": [],
      "key": "21",
      "summonerLevel": 4,
      "modes": [
        "ARAM",
        "FIRSTBLOOD",
        "TUTORIAL",
        "CLASSIC",
        "STARGUARDIAN",
        "GAMEMODEX",
        "PROJECT",
        "ARSR",
        "ASSASSINATE",
        "DOOMBOTSTEEMO",
        "ONEFORALL",
        "PRACTICETOOL",
        "URF"
      ],
      "costType": "No Cost",
      "maxammo": "-1",
      "range": [
        1200
      ],
      "rangeBurn": "1200",
      "image": {
        "full": "SummonerBarrier.png",
        "sprite": "spell0.png",
        "group": "spell",
        "x": 0,
        "y": 0,
        "w": 48,
        "h": 48
      },
      "resource": "No Cost"
    },
    "SummonerBoost": {
      "id": "SummonerBoost",
      "name": "Cleanse",
      "description": "Removes all disables (excluding suppression and airborne) and summoner spell debuffs affecting your champion and lowers the duration of incoming disables by 65% for 3 seconds.",
      "tooltip": "Removes all disables (excluding suppression and airborne) and summoner spell debuffs affecting your champion and reduces the duration of disables by 65% for the next {{ f1 }} seconds.",
      "maxrank": 1,
      "cooldown": [
        210
      ],
      "cooldownBurn": "210",
      "cost": [
        0
      ],
      "costBurn": "0",
      "datavalues": {},
      "effect": [
        null,
        [
          0.65
        ],
        [
          3
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ]
      ],
      "effectBurn": [
        null,
        "0.65",
        "3",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0"
      ],
      "vars": [
        {
          "link": "@text",
          "coeff": 3,
          "key": "f1"
        }
      ],
      "key": "1",
      "summonerLevel": 9,
      "modes": [
        "CLASSIC",
        "ODIN",
        "TUTORIAL",
        "ARAM",
        "ASCENSION",
        "FIRSTBLOOD",
        "URF",
        "ARSR",
        "DOOMBOTSTEEMO",
        "PROJECT",
        "ONEFORALL",
        "GAMEMODEX",
        "PRACTICETOOL"
      ],
      "costType": "No Cost",
      "maxammo": "-1",
      "range": [
        200
      ],
      "rangeBurn": "200",
      "image": {
        "full": "SummonerBoost.png",
        "sprite": "spell0.png",
        "group": "spell",
        "x": 48,
        "y": 0,
        "w": 48,
        "h": 48
      },
      "resource": "No Cost"
    },
    "SummonerDot": {
      "id": "SummonerDot",
      "name": "Ignite",
      "description": "Ignites target enemy champion, dealing 70-410 true damage (depending on champion level) over 5 seconds, grants you vision of the target, and reduces healing effects on them for the duration.",
      "tooltip": "Ignite deals <span class=\"colorFEFCFF\">{{ f1 }}</span> true damage to target enemy champion over 5 seconds, grants you vision of the target and applies Grievous Wounds for the duration.<br /><br /><rules>(Grievous Wounds reduces healing effects by 40%. This vision does not reveal stealthed enemies.)</rules>",
      "maxrank": 1,
      "cooldown": [
        180
      ],
      "cooldownBurn": "180",
      "cost": [
        0
      ],
      "costBurn": "0",
      "datavalues": {},
      "effect": [
        null,
        [
          5
        ],
        [
          10
        ],
        [
          4
        ],
        [
          100
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ]
      ],
      "effectBurn": [
        null,
        "5",
        "10",
        "4",
        "100",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0"
      ],
      "vars": [
        {
          "link": "@player.level",
          "coeff": [
            70,
            90,
            110,
            130,
            150,
            170,
            190,
            210,
            230,
            250,
            270,
            290,
            310,
            330,
            350,
            370,
            390,
            410
          ],
          "key": "f1"
        }
      ],
      "key": "14",
      "summonerLevel": 9,
      "modes": [
        "CLASSIC",
        "ODIN",
        "TUTORIAL",
        "ARAM",
        "ASCENSION",
        "FIRSTBLOOD",
        "ASSASSINATE",
        "URF",
        "ARSR",
        "DOOMBOTSTEEMO",
        "ONEFORALL",
        "GAMEMODEX",
        "PRACTICETOOL"
      ],
      "costType": "No Cost",
      "maxammo": "-1",
      "range": [
        600
      ],
      "rangeBurn": "600",
      "image": {
        "full": "SummonerDot.png",
        "sprite": "spell0.png",
        "group": "spell",
        "x": 96,
        "y": 0,
        "w": 48,
        "h": 48
      },
      "resource": "No Cost"
    },
    "SummonerExhaust": {
      "id": "SummonerExhaust",
      "name": "Exhaust",
      "description": "Exhausts target enemy champion, reducing their Movement Speed by 30%, and their damage dealt by 40% for 2.5 seconds.",
      "tooltip": "Exhausts target enemy champion, reducing their Movement Speed by {{ f3 }}%, and their damage dealt by {{ f2 }}% for 2.5 seconds.",
      "maxrank": 1,
      "cooldown": [
        210
      ],
      "cooldownBurn": "210",
      "cost": [
        0
      ],
      "costBurn": "0",
      "datavalues": {},
      "effect": [
        null,
        [
          2.5
        ],
        [
          40
        ],
        [
          0
        ],
        [
          0
        ],
        [
          30
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ]
      ],
      "effectBurn": [
        null,
        "2.5",
        "40",
        "0",
        "0",
        "30",
        "0",
        "0",
        "0",
        "0",
        "0"
      ],
      "vars": [],
      "key": "3",
      "summonerLevel": 4,
      "modes": [
        "ARAM",
        "TUTORIAL",
        "CLASSIC",
        "GAMEMODEX",
        "URF",
        "ARSR",
        "DOOMBOTSTEEMO",
        "ONEFORALL",
        "PRACTICETOOL"
      ],
      "costType": "No Cost",
      "maxammo": "-1",
      "range": [
        650
      ],
      "rangeBurn": "650",
      "image": {
        "full": "SummonerExhaust.png",
        "sprite": "spell0.png",
        "group": "spell",
        "x": 144,
        "y": 0,
        "w": 48,
        "h": 48
      },
      "resource": "No Cost"
    },
    "SummonerFlash": {
      "id": "SummonerFlash",
      "name": "Flash",
      "description": "Teleports your champion a short distance toward your cursor's location.",
      "tooltip": "Teleports your champion a short distance toward your cursor's location.",
      "maxrank": 1,
      "cooldown": [
        300
      ],
      "cooldownBurn": "300",
      "cost": [
        0
      ],
      "costBurn": "0",
      "datavalues": {},
      "effect": [
        null,
        [
          400
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ]
      ],
      "effectBurn": [
        null,
        "400",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0"
      ],
      "vars": [],
      "key": "4",
      "summonerLevel": 7,
      "modes": [
        "CLASSIC",
        "ODIN",
        "TUTORIAL",
        "ARAM",
        "ASCENSION",
        "FIRSTBLOOD",
        "ASSASSINATE",
        "URF",
        "ARSR",
        "DOOMBOTSTEEMO",
        "STARGUARDIAN",
        "PROJECT",
        "SNOWURF",
        "ONEFORALL",
        "GAMEMODEX",
        "PRACTICETOOL"
      ],
      "costType": "No Cost",
      "maxammo": "-1",
      "range": [
        425
      ],
      "rangeBurn": "425",
      "image": {
        "full": "SummonerFlash.png",
        "sprite": "spell0.png",
        "group": "spell",
        "x": 192,
        "y": 0,
        "w": 48,
        "h": 48
      },
      "resource": "No Cost"
    },
    "SummonerHaste": {
      "id": "SummonerHaste",
      "name": "Ghost",
      "description": "Your champion gains increased Movement Speed and can move through units for 10 seconds. Grants a maximum of 28-45% (depending on champion level) Movement Speed after accelerating for 2 seconds.",
      "tooltip": "Your champion gains increased Movement Speed and can move through units for 10 seconds. Grants a maximum of {{ f1 }}% Movement Speed after accelerating for 2 seconds.",
      "maxrank": 1,
      "cooldown": [
        180
      ],
      "cooldownBurn": "180",
      "cost": [
        0
      ],
      "costBurn": "0",
      "datavalues": {},
      "effect": [
        null,
        [
          27
        ],
        [
          0
        ],
        [
          2
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ]
      ],
      "effectBurn": [
        null,
        "27",
        "0",
        "2",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0"
      ],
      "vars": [
        {
          "link": "@text",
          "coeff": 27,
          "key": "f1"
        }
      ],
      "key": "6",
      "summonerLevel": 1,
      "modes": [
        "CLASSIC",
        "ODIN",
        "TUTORIAL",
        "ARAM",
        "ASCENSION",
        "FIRSTBLOOD",
        "ASSASSINATE",
        "URF",
        "ARSR",
        "DOOMBOTSTEEMO",
        "STARGUARDIAN",
        "PROJECT",
        "ONEFORALL",
        "TUTORIAL_MODULE_1",
        "TUTORIAL_MODULE_2",
        "GAMEMODEX",
        "PRACTICETOOL"
      ],
      "costType": "No Cost",
      "maxammo": "-1",
      "range": [
        200
      ],
      "rangeBurn": "200",
      "image": {
        "full": "SummonerHaste.png",
        "sprite": "spell0.png",
        "group": "spell",
        "x": 240,
        "y": 0,
        "w": 48,
        "h": 48
      },
      "resource": "No Cost"
    },
    "SummonerHeal": {
      "id": "SummonerHeal",
      "name": "Heal",
      "description": "Restores 90-345 Health (depending on champion level) and grants 30% Movement Speed for 1 second to you and target allied champion. This healing is halved for units recently affected by Summoner Heal.",
      "tooltip": "Restores {{ f1 }} Health and grants 30% Movement Speed for 1 second to your champion and target allied champion. This healing is halved for units recently affected by Summoner Heal.<br /><br /><span class=\"colorFFFF00\">If this spell cannot find a target, it will cast on the most wounded allied champion in range.</span>",
      "maxrank": 1,
      "cooldown": [
        240
      ],
      "cooldownBurn": "240",
      "cost": [
        0
      ],
      "costBurn": "0",
      "datavalues": {},
      "effect": [
        null,
        [
          0.3
        ],
        [
          75
        ],
        [
          15
        ],
        [
          0.5
        ],
        [
          826
        ],
        [
          0.5
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ]
      ],
      "effectBurn": [
        null,
        "0.3",
        "75",
        "15",
        "0.5",
        "826",
        "0.5",
        "0",
        "0",
        "0",
        "0"
      ],
      "vars": [
        {
          "link": "@player.level",
          "coeff": [
            90,
            105,
            120,
            135,
            150,
            165,
            180,
            195,
            210,
            225,
            240,
            255,
            270,
            285,
            300,
            315,
            330,
            345
          ],
          "key": "f1"
        }
      ],
      "key": "7",
      "summonerLevel": 1,
      "modes": [
        "ARAM",
        "TUTORIAL",
        "CLASSIC",
        "STARGUARDIAN",
        "GAMEMODEX",
        "TUTORIAL_MODULE_2",
        "URF",
        "ARSR",
        "ASSASSINATE",
        "DOOMBOTSTEEMO",
        "ONEFORALL",
        "PRACTICETOOL",
        "TUTORIAL_MODULE_1",
        "PROJECT"
      ],
      "costType": "No Cost",
      "maxammo": "-1",
      "range": [
        850
      ],
      "rangeBurn": "850",
      "image": {
        "full": "SummonerHeal.png",
        "sprite": "spell0.png",
        "group": "spell",
        "x": 288,
        "y": 0,
        "w": 48,
        "h": 48
      },
      "resource": "No Cost"
    },
    "SummonerMana": {
      "id": "SummonerMana",
      "name": "Clarity",
      "description": "Restores 50% of your champion's maximum Mana. Also restores allies for 25% of their maximum Mana.",
      "tooltip": "Restores {{ f1 }}% maximum Mana to your Champion and {{ f2 }}% to nearby allies.",
      "maxrank": 1,
      "cooldown": [
        240
      ],
      "cooldownBurn": "240",
      "cost": [
        0
      ],
      "costBurn": "0",
      "datavalues": {},
      "effect": [
        null,
        [
          50
        ],
        [
          25
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ]
      ],
      "effectBurn": [
        null,
        "50",
        "25",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0"
      ],
      "vars": [
        {
          "link": "@player.level",
          "coeff": [
            190,
            220,
            250,
            280,
            310,
            340,
            370,
            400,
            430,
            460,
            490,
            520,
            550,
            580,
            610,
            640,
            670,
            700
          ],
          "key": "f1"
        },
        {
          "link": "@player.level",
          "coeff": [
            95,
            110,
            125,
            140,
            155,
            170,
            185,
            200,
            215,
            230,
            245,
            260,
            275,
            290,
            305,
            320,
            335,
            350
          ],
          "key": "f2"
        }
      ],
      "key": "13",
      "summonerLevel": 6,
      "modes": [
        "ODIN",
        "ARAM",
        "ASCENSION",
        "FIRSTBLOOD"
      ],
      "costType": "No Cost",
      "maxammo": "-1",
      "range": [
        600
      ],
      "rangeBurn": "600",
      "image": {
        "full": "SummonerMana.png",
        "sprite": "spell0.png",
        "group": "spell",
        "x": 336,
        "y": 0,
        "w": 48,
        "h": 48
      },
      "resource": "No Cost"
    },
    "SummonerOdysseyFlash": {
      "id": "SummonerOdysseyFlash",
      "name": "Warp",
      "description": "Dash through spacetime, becoming briefly untargetable and invulnerable as you rapidly move towards a location.",
      "tooltip": "Turn briefly <attention>untargetable</attention> and <attention>invulnerable</attention> as you dash towards a location.<br /><br /><rules>Keep your arms and legs inside the wormhole.</rules>",
      "maxrank": 1,
      "cooldown": [
        0.5
      ],
      "cooldownBurn": "0.5",
      "cost": [
        0
      ],
      "costBurn": "0",
      "datavalues": {},
      "effect": [
        null,
        [
          1000
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ]
      ],
      "effectBurn": [
        null,
        "1000",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0"
      ],
      "vars": [],
      "key": "52",
      "summonerLevel": 1,
      "modes": [
        "ODYSSEY"
      ],
      "costType": "No Cost",
      "maxammo": "3",
      "range": [
        825
      ],
      "rangeBurn": "825",
      "image": {
        "full": "SummonerOdysseyFlash.png",
        "sprite": "spell0.png",
        "group": "spell",
        "x": 384,
        "y": 0,
        "w": 48,
        "h": 48
      },
      "resource": "No Cost"
    },
    "SummonerOdysseyRevive": {
      "id": "SummonerOdysseyRevive",
      "name": "Resuscitate",
      "description": "Revive a fallen friend by remaining next to them for 2 seconds. Exiting the area early does not consume your cooldown. ",
      "tooltip": "<keywordWard>Revive</keywordWard> a fallen crewmember by remaining next to them for <attention>2</attention> seconds. <br /><br /><rules>Exiting the area early does not consume your cooldown. </rules>",
      "maxrank": 1,
      "cooldown": [
        100
      ],
      "cooldownBurn": "100",
      "cost": [
        0
      ],
      "costBurn": "0",
      "datavalues": {},
      "effect": [
        null,
        [
          1
        ],
        [
          2
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ]
      ],
      "effectBurn": [
        null,
        "1",
        "2",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0"
      ],
      "vars": [],
      "key": "50",
      "summonerLevel": 1,
      "modes": [
        "ODYSSEY"
      ],
      "costType": "No Cost",
      "maxammo": "-1",
      "range": [
        350
      ],
      "rangeBurn": "350",
      "image": {
        "full": "SummonerOdysseyRevive.png",
        "sprite": "spell0.png",
        "group": "spell",
        "x": 432,
        "y": 0,
        "w": 48,
        "h": 48
      },
      "resource": "No Cost"
    },
    "SummonerPoroRecall": {
      "id": "SummonerPoroRecall",
      "name": "To the King!",
      "description": "Quickly travel to the Poro King's side.",
      "tooltip": "<span class=\"colorFFE076\">Passive:</span> Hitting an enemy champion with a Poro gives your team a Poro Mark. Upon reaching 10 Poro Marks, your team summons the Poro King to fight alongside them. While the Poro King is active, no Poro Marks can be scored by either team.<br /><br /><span class=\"colorFFE076\">Active:</span> Quickly dash to King Poro's side. Can only be cast while the Poro King is summoned for your team. <br /><br /><i><span class=\"colorFDD017\">''Poros tug the heartstrings. The rest of you just comes along for the ride.''</span></i>",
      "maxrank": 1,
      "cooldown": [
        10
      ],
      "cooldownBurn": "10",
      "cost": [
        0
      ],
      "costBurn": "0",
      "datavalues": {},
      "effect": [
        null,
        [
          3000
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ]
      ],
      "effectBurn": [
        null,
        "3000",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0"
      ],
      "vars": [],
      "key": "30",
      "summonerLevel": 1,
      "modes": [
        "KINGPORO"
      ],
      "costType": "No Cost",
      "maxammo": "-1",
      "range": [
        200
      ],
      "rangeBurn": "200",
      "image": {
        "full": "SummonerPoroRecall.png",
        "sprite": "spell0.png",
        "group": "spell",
        "x": 0,
        "y": 48,
        "w": 48,
        "h": 48
      },
      "resource": "No Cost"
    },
    "SummonerPoroThrow": {
      "id": "SummonerPoroThrow",
      "name": "Poro Toss",
      "description": "Toss a Poro at your enemies. If it hits, you can quickly travel to your target as a follow up.",
      "tooltip": "Toss a Poro a long distance, dealing {{ f2 }} true damage to the first enemy unit hit, granting <span class=\"coloree91d7\">True Sight</span> of the target.<br /><br />This ability can be recast for 3 seconds if it hits an enemy to dash to the target hit, dealing {{ f2 }} more true damage and reducing the cooldown of the next Poro Toss by {{ e4 }} seconds.<br /><br />Poros are not blocked by spell shields or wind walls because they are animals, not spells!<br /><br /><i><span class=\"colorFDD017\">''Poros are a model for Runeterran aerodynamics.''</span></i>",
      "maxrank": 1,
      "cooldown": [
        20
      ],
      "cooldownBurn": "20",
      "cost": [
        0
      ],
      "costBurn": "0",
      "datavalues": {},
      "effect": [
        null,
        [
          20
        ],
        [
          10
        ],
        [
          3
        ],
        [
          5
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ]
      ],
      "effectBurn": [
        null,
        "20",
        "10",
        "3",
        "5",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0"
      ],
      "vars": [],
      "key": "31",
      "summonerLevel": 1,
      "modes": [
        "KINGPORO"
      ],
      "costType": "No Cost",
      "maxammo": "-1",
      "range": [
        2500
      ],
      "rangeBurn": "2500",
      "image": {
        "full": "SummonerPoroThrow.png",
        "sprite": "spell0.png",
        "group": "spell",
        "x": 48,
        "y": 48,
        "w": 48,
        "h": 48
      },
      "resource": "No Cost"
    },
    "SummonerSmite": {
      "id": "SummonerSmite",
      "name": "Smite",
      "description": "Deals 390-1000 true damage (depending on champion level) to target epic, large, or medium monster or enemy minion. Restores Health based on your maximum life when used against monsters.",
      "tooltip": "Deals <span class=\"colorFEFCFF\">{{ f1 }}</span> true damage to target epic, large, or medium monster or enemy minion.  Against monsters, additionally restores <span class=\"colorFFFFFF\">{{ f6 }}</span> <span class=\"colorFF6666\">(+{{ f7 }})</span> Health.<br /><br />Smite regains a charge every {{ ammorechargetime }} seconds, up to a maximum of 2 charges.",
      "maxrank": 1,
      "cooldown": [
        15
      ],
      "cooldownBurn": "15",
      "cost": [
        0
      ],
      "costBurn": "0",
      "datavalues": {},
      "effect": [
        null,
        [
          15
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ]
      ],
      "effectBurn": [
        null,
        "15",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0"
      ],
      "vars": [
        {
          "link": "@player.level",
          "coeff": [
            390,
            410,
            430,
            450,
            480,
            510,
            540,
            570,
            600,
            640,
            680,
            720,
            760,
            800,
            850,
            900,
            950,
            1000
          ],
          "key": "f1"
        }
      ],
      "key": "11",
      "summonerLevel": 9,
      "modes": [
        "URF",
        "CLASSIC",
        "ARSR",
        "DOOMBOTSTEEMO",
        "ONEFORALL",
        "PRACTICETOOL",
        "TUTORIAL",
        "GAMEMODEX"
      ],
      "costType": "No Cost",
      "maxammo": "2",
      "range": [
        500
      ],
      "rangeBurn": "500",
      "image": {
        "full": "SummonerSmite.png",
        "sprite": "spell0.png",
        "group": "spell",
        "x": 96,
        "y": 48,
        "w": 48,
        "h": 48
      },
      "resource": "No Cost"
    },
    "SummonerSnowURFSnowball_Mark": {
      "id": "SummonerSnowURFSnowball_Mark",
      "name": "Ultra (Rapidly Flung) Mark",
      "description": "It's a snowball! It's a Poro! It's...uh...one of those.",
      "tooltip": "Throw a snowball approximately 1 Really Far units away, dealing {{ f1 }} true damage to the first enemy unit hit and granting <span class=\"coloree91d7\">True Sight</span> of the target.<br /><br />If your Ultra Mark hits an enemy, this ability can be recast for {{ e3 }} seconds to Dash to the tagged unit, dealing an additional {{ f1 }} true damage and increasing your swagger by like a million percent.<br /><br />If you have Poros following you, you throw a Poro instead of a Snowball, because we're terrible people.",
      "maxrank": 1,
      "cooldown": [
        80
      ],
      "cooldownBurn": "80",
      "cost": [
        0
      ],
      "costBurn": "0",
      "datavalues": {},
      "effect": [
        null,
        [
          10
        ],
        [
          5
        ],
        [
          3
        ],
        [
          0.25
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ]
      ],
      "effectBurn": [
        null,
        "10",
        "5",
        "3",
        "0.25",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0"
      ],
      "vars": [],
      "key": "39",
      "summonerLevel": 6,
      "modes": [
        "SNOWURF"
      ],
      "costType": "No Cost",
      "maxammo": "-1",
      "range": [
        8000
      ],
      "rangeBurn": "8000",
      "image": {
        "full": "SummonerSnowURFSnowball_Mark.png",
        "sprite": "spell0.png",
        "group": "spell",
        "x": 144,
        "y": 48,
        "w": 48,
        "h": 48
      },
      "resource": "No Cost"
    },
    "SummonerSnowball": {
      "id": "SummonerSnowball",
      "name": "Mark",
      "description": "Throw a snowball in a straight line at your enemies. If it hits an enemy, they become marked, granting True Sight, and your champion can quickly travel to the marked target as a follow up.",
      "tooltip": "Throw a snowball a long distance, dealing {{ f1 }} true damage to the first enemy unit hit and granting <span class=\"coloree91d7\">True Sight</span> of the target. If it hits an enemy, this ability can be recast for {{ e3 }} seconds to Dash to the tagged unit, dealing an additional {{ f1 }} true damage. Dashing to the target will reduce the cooldown of Mark by {{ e4 }}%.<br /><br /><span class=\"colorFFFF00\">Mark projectiles are not stopped by spell shields or projectile mitigation.</span>",
      "maxrank": 1,
      "cooldown": [
        80
      ],
      "cooldownBurn": "80",
      "cost": [
        0
      ],
      "costBurn": "0",
      "datavalues": {},
      "effect": [
        null,
        [
          10
        ],
        [
          5
        ],
        [
          3
        ],
        [
          25
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ]
      ],
      "effectBurn": [
        null,
        "10",
        "5",
        "3",
        "25",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0"
      ],
      "vars": [],
      "key": "32",
      "summonerLevel": 6,
      "modes": [
        "ARAM",
        "FIRSTBLOOD"
      ],
      "costType": "No Cost",
      "maxammo": "-1",
      "range": [
        1600
      ],
      "rangeBurn": "1600",
      "image": {
        "full": "SummonerSnowball.png",
        "sprite": "spell0.png",
        "group": "spell",
        "x": 192,
        "y": 48,
        "w": 48,
        "h": 48
      },
      "resource": "No Cost"
    },
    "SummonerTeleport": {
      "id": "SummonerTeleport",
      "name": "Teleport",
      "description": "After channeling for 4 seconds, teleports your champion to target allied structure, minion, or ward.",
      "tooltip": "After channeling for {{ f1 }} seconds, your champion teleports to target allied structure, minion, or ward.",
      "maxrank": 1,
      "cooldown": [
        360
      ],
      "cooldownBurn": "360",
      "cost": [
        0
      ],
      "costBurn": "0",
      "datavalues": {},
      "effect": [
        null,
        [
          4
        ],
        [
          240
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ],
        [
          0
        ]
      ],
      "effectBurn": [
        null,
        "4",
        "240",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0"
      ],
      "vars": [
        {
          "link": "@text",
          "coeff": 4,
          "key": "f1"
        }
      ],
      "key": "12",
      "summonerLevel": 7,
      "modes": [
        "CLASSIC",
        "TUTORIAL",
        "ASSASSINATE",
        "ARSR",
        "DOOMBOTSTEEMO",
        "ONEFORALL",
        "PRACTICETOOL",
        "GAMEMODEX"
      ],
      "costType": "No Cost",
      "maxammo": "-1",
      "range": [
        25000
      ],
      "rangeBurn": "25000",
      "image": {
        "full": "SummonerTeleport.png",
        "sprite": "spell0.png",
        "group": "spell",
        "x": 240,
        "y": 48,
        "w": 48,
        "h": 48
      },
      "resource": "No Cost"
    }
  }
}""".trimIndent()