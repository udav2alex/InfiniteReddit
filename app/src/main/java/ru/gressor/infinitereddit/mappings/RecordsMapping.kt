package ru.gressor.infinitereddit.mappings

import ru.gressor.infinitereddit.api.entities.Child
import ru.gressor.infinitereddit.entities.RedditRecord

fun Child.toRedditRecord() = RedditRecord(
    data.title ?: "",
    data.totalAwardsReceived ?: 0,
    data.numComments ?: 0
)