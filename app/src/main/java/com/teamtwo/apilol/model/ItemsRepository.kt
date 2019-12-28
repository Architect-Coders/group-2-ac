package com.teamtwo.apilol.model

class ItemsRepository {

    suspend fun getItems() = LOLServiceManager().service.getAllItems("es_ES")
}