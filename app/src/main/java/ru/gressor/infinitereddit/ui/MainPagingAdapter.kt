package ru.gressor.infinitereddit.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import ru.gressor.infinitereddit.databinding.ItemMainRecordBinding
import ru.gressor.infinitereddit.entities.RedditRecord

class MainPagingAdapter(diffCallback: DiffUtil.ItemCallback<RedditRecord>) :
    PagingDataAdapter<RedditRecord, MainViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainViewHolder(
        ItemMainRecordBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}