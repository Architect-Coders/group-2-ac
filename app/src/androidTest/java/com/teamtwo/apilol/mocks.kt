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
          "plaintext": "Botas para aumentar velocidad"
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
          ]
        },
        "2": {
          "name": "Botas nuevas",
          "description": "Botas nuevas",
          "plaintext": "Botas para aumentar mucho la velocidad"
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
          ]
        }
      }
    }
""".trimIndent()