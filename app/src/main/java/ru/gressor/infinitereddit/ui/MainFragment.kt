package ru.gressor.infinitereddit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.gressor.infinitereddit.databinding.FragmentMainBinding
import ru.gressor.infinitereddit.repo.RecordRepositoryRetrofit
import ru.gressor.infinitereddit.repo.RecordRepositoryStub
import ru.gressor.infinitereddit.vm.MainViewModel
import ru.gressor.infinitereddit.vm.MainViewModelFactory

class MainFragment: BaseFragment<FragmentMainBinding>() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this, MainViewModelFactory(
            RecordRepositoryRetrofit() // RecordRepositoryStub()
        ))
            .get(MainViewModel::class.java)
    }

    private lateinit var adapter: MainRecycler

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = MainRecycler()
        binding.mainRecycler.adapter = adapter
        binding.mainRecycler.layoutManager = LinearLayoutManager(context)

        lifecycleScope.launch {
            viewModel
                .stateFlow
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {
                    adapter.populate(it)
                }
        }
    }

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentMainBinding.inflate(inflater, container, false)
}