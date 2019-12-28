package com.teamtwo.apilol.model

class SpellsRepository {

    suspend fun getSpells() = LOLServiceManager().service.getSpells()

}