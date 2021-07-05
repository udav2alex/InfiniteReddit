package ru.gressor.infinitereddit.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.gressor.infinitereddit.databinding.ItemMainRecordBinding
import ru.gressor.infinitereddit.entities.RedditRecord

class MainRecycler : RecyclerView.Adapter<MainRecycler.MainViewHolder>() {
    private val mutableList = mutableListOf<RedditRecord>()

    fun populate(list: List<RedditRecord>) {
        mutableList.clear()
        mutableList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainViewHolder(
        ItemMainRecordBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(mutableList[position])
    }

    override fun getItemCount() = mutableList.size

    inner class MainViewHolder(private val binding: ItemMainRecordBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(redditRecord: RedditRecord) {
            with(binding) {
                redditTextView.text = redditRecord.text
                starsTextView.text = redditRecord.stars.toString()
                commentsTextView.text = redditRecord.comments.toString()
            }
        }
    }
}