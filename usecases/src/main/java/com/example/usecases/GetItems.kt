package com.example.usecases

import com.example.data.ItemsRepository
import com.example.domain.Item

class GetItems(private val itemsRepository: ItemsRepository) {

    suspend fun invoke(): List<Item> = itemsRepository.getItems()
}
