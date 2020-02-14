package com.example.usecases

import com.example.data.ItemsRepository
import com.example.domain.Item

class GetItem(private val itemsRepository: ItemsRepository) {

    suspend fun invoke(itemId: String): Item
            = itemsRepository.findItemById(itemId)
}