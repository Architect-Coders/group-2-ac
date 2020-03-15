package com.example.data

interface LocationDataSource {
    suspend fun findLastRegion(): String?
}