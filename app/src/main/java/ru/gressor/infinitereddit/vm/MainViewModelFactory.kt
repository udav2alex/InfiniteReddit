package ru.gressor.infinitereddit.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.gressor.infinitereddit.repo.RecordRepository

class MainViewModelFactory(
    private val recordRepository: RecordRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        when (modelClass) {
            MainViewModel::class.java -> MainViewModel(recordRepository)
            else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
        } as T
}