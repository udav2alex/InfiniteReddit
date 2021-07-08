package ru.gressor.infinitereddit.ui

import androidx.recyclerview.widget.DiffUtil
import ru.gressor.infinitereddit.entities.RedditRecord

object RedditRecordComparator : DiffUtil.ItemCallback<RedditRecord>() {
    override fun areItemsTheSame(oldItem: RedditRecord, newItem: RedditRecord): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: RedditRecord, newItem: RedditRecord): Boolean {
        return oldItem == newItem
    }
}