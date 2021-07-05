package ru.gressor.infinitereddit.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import ru.gressor.infinitereddit.entities.RedditRecord
import ru.gressor.infinitereddit.repo.RecordRepository

class MainViewModel(
    recordRepository: RecordRepository
) : ViewModel() {

    val stateFlow: StateFlow<List<RedditRecord>> = flow {
        emit(recordRepository.getRecords())
    }
        .stateIn(viewModelScope, SharingStarted.Eagerly, listOf())
}