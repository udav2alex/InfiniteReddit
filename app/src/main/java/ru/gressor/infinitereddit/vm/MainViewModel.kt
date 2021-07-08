package ru.gressor.infinitereddit.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import ru.gressor.infinitereddit.api.ApiService
import ru.gressor.infinitereddit.repo.RecordPagingSource

class MainViewModel(
    apiService: ApiService
) : ViewModel() {

    val flow = Pager(
        PagingConfig(pageSize = 25),
    ) {
        RecordPagingSource(apiService)
    }.flow
        .cachedIn(viewModelScope)
}