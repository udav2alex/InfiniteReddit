package ru.gressor.infinitereddit.entities

data class RedditRecord(
    val text: String,
    val stars: Int = 0,
    val comments: Int = 0
)