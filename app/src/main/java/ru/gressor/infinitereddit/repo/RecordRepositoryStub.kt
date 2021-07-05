package ru.gressor.infinitereddit.repo

import ru.gressor.infinitereddit.entities.RedditRecord

class RecordRepositoryStub: RecordRepository {
    override suspend fun getRecords() = listOf<RedditRecord>(
        RedditRecord("test1 test1 test1 test1 test1 test1", 10, 2),
        RedditRecord("test1 test1 test1 test1 test1 test1", 0, 20),
        RedditRecord("test1 test1 test1 test1 test1 test1", 1000, 0),
        RedditRecord("test1 test1 test1 test1 test1 test1", 2, 2),
        RedditRecord("test1 test1 test1 test1 test1 test1", 10, 2000)
    )
}