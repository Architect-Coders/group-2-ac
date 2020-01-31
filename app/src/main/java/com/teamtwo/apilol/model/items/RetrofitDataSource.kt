package com.teamtwo.apilol.model.items

import com.example.data.RemoteDataSourceItems
import com.example.domain.Item as ItemDomain
import com.teamtwo.apilol.model.LOLServiceManager

class RetrofitDataSource: RemoteDataSourceItems {

    override suspend fun getItems(): List<ItemDomain> {
        val itemsResponse = LOLServiceManager().service.getAllItems("es-ES")
        return itemsResponse.body()?.data?.values?.toList() ?: emptyList()
    }
}
