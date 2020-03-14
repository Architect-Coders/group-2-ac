package com.teamtwo.apilol.model.items

import android.app.Application
import com.example.data.RemoteDataSourceItems
import com.teamtwo.apilol.Sensor.CountryCode
import com.example.domain.Item as ItemDomain
import com.teamtwo.apilol.model.LOLServiceManager

class RetrofitDataSource(
    private val lolServiceManager: LOLServiceManager
): RemoteDataSourceItems {

    override suspend fun getItems(): List<ItemDomain> {
        val itemsResponse = lolServiceManager.service.getAllItems(CountryCode(Application()).getCode())
        return itemsResponse.body()?.data?.values?.toList() ?: emptyList()
    }
}
