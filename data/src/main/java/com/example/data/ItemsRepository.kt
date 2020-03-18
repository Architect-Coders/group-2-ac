package com.example.data
import com.example.domain.Item


class ItemsRepository(
    private val localDataSourceItems: LocalDataSourceItems,
    private val remoteDataSourceItems: RemoteDataSourceItems,
    private val regionRepository: RegionRepository
){
    suspend fun getItems(): List<Item> {

        if (!localDataSourceItems.itemsExists()){
            val region: String = CountryLanguage.valueOf(regionRepository.findLastRegion()).code
            val items = remoteDataSourceItems.getItems(region)
            localDataSourceItems.saveItems(items)
        }

        return localDataSourceItems.getItems()
    }

    suspend fun updateItem(item: Item){
        localDataSourceItems.updateItem(item)
    }

    suspend fun findItemById(itemId: String): Item
            = localDataSourceItems.findItemById(itemId)
}

interface LocalDataSourceItems {
    suspend fun itemsExists(): Boolean
    suspend fun saveItems(items: List<Item>)
    suspend fun getItems(): List<Item>
    suspend fun updateItem(item: Item)
    suspend fun findItemById(itemId: String): Item
}

interface RemoteDataSourceItems {
    suspend fun getItems(region: String): List<Item>
}
