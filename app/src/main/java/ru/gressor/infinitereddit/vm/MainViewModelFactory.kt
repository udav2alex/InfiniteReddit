package ru.gressor.infinitereddit.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.gressor.infinitereddit.api.ApiService

class MainViewModelFactory(
    private val apiService: ApiService
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        when (modelClass) {
            MainViewModel::class.java -> MainViewModel(apiService)
            else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
        } as T
}