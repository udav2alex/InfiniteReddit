package ru.gressor.infinitereddit.repo

import ru.gressor.infinitereddit.api.ApiServiceCreator
import ru.gressor.infinitereddit.entities.RedditRecord

class RecordRepositoryRetrofit: RecordRepository {
    private val apiService = ApiServiceCreator().getService()

    override suspend fun getRecords(): List<RedditRecord> {
        val response = apiService.getResponse()
        val list = response.data.children
            .map {
                RedditRecord(
                    it.data.title ?: "",
                    it.data.totalAwardsReceived ?: 0,
                    it.data.numComments ?: 0
                )
            }
        return list
    }
}