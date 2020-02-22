package com.teamtwo.apilol.model.matches

import com.example.data.MatchesLocalDataSource
import com.example.domain.FeaturedGameInfo
import com.teamtwo.apilol.model.database.ApiLolDatabase
import com.teamtwo.apilol.model.database.entities.MatchesEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MatchesRoomDataSource(database: ApiLolDatabase): MatchesLocalDataSource {

    private val dao = database.apiLolDao()

    override suspend fun saveMatches(matches: List<FeaturedGameInfo>) = withContext(Dispatchers.IO) {
        dao.insertMatches(matches.map(FeaturedGameInfo::toDbEntity))
    }

    override suspend fun getOldMatches(): List<FeaturedGameInfo> = withContext(Dispatchers.IO) {
        dao.getOldMatches().map(MatchesEntity::toDomainObject)
    }

    override suspend fun hasOldMatches(): Boolean = withContext(Dispatchers.IO) {
        dao.countMatches() > 0
    }
}