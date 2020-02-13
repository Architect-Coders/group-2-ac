package com.teamtwo.apilol.model.items

import com.example.data.LocalDataSourceItems
import com.teamtwo.apilol.model.database.ApiLolDatabase
import com.teamtwo.apilol.model.database.entities.ItemEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.domain.Item as ItemDomain

class RoomDataSource(database: ApiLolDatabase) : LocalDataSourceItems {

    private val dao = database.apiLolDao()

    override suspend fun itemsExists(): Boolean = withContext(Dispatchers.IO) {
        dao.getItemsRecordCount() > 0
    }

    override suspend fun saveItems(items: List<ItemDomain>) = withContext(Dispatchers.IO) {
        dao.insertItem(items.map(ItemDomain::toItemEntity))
    }

    override suspend fun getItems(): List<ItemDomain> = withContext(Dispatchers.IO){
        dao.getAllItems().map(ItemEntity::toItemDomain)
    }

    override suspend fun updateItem(item: ItemDomain) = withContext(Dispatchers.IO){
        dao.updateItem(item.toItemEntity())
    }

    override suspend fun findItemById(itemId: String): ItemDomain = withContext(Dispatchers.IO){
        dao.getItemById(itemId).toItemDomain()
    }
}