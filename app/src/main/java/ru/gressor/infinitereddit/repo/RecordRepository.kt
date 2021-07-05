package ru.gressor.infinitereddit.repo

import ru.gressor.infinitereddit.entities.RedditRecord

interface RecordRepository {
    suspend fun getRecords(): List<RedditRecord>
}