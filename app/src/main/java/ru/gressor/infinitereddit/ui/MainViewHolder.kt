package ru.gressor.infinitereddit.ui

import androidx.recyclerview.widget.RecyclerView
import ru.gressor.infinitereddit.databinding.ItemMainRecordBinding
import ru.gressor.infinitereddit.entities.RedditRecord

class MainViewHolder(
    private val binding: ItemMainRecordBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(redditRecord: RedditRecord?) {
        with(binding) {
            redditTextView.text = redditRecord?.text ?: "--------"
            starsTextView.text = redditRecord?.stars.toString()
            commentsTextView.text = redditRecord?.comments.toString()
        }
    }
}