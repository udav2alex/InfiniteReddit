package ru.gressor.infinitereddit.repo

import ru.gressor.infinitereddit.api.ApiServiceCreator
import ru.gressor.infinitereddit.entities.RedditRecord
import ru.gressor.infinitereddit.mappings.toRedditRecord

class RecordRepositoryRetrofit: RecordRepository {
    private val apiService = ApiServiceCreator().getService()

    override suspend fun getRecords(): List<RedditRecord> {
        val response = apiService.getResponse()

        return response.data.children.map { it.toRedditRecord() }
    }
}