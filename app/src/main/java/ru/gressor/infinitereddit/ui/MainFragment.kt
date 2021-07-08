package ru.gressor.infinitereddit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.gressor.infinitereddit.api.ApiServiceCreator
import ru.gressor.infinitereddit.databinding.FragmentMainBinding
import ru.gressor.infinitereddit.vm.MainViewModel
import ru.gressor.infinitereddit.vm.MainViewModelFactory

class MainFragment : BaseFragment<FragmentMainBinding>() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(
            this, MainViewModelFactory(
                ApiServiceCreator().getService()
            )
        ).get(MainViewModel::class.java)
    }

    private lateinit var adapter: MainPagingAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        adapter = MainPagingAdapter(RedditRecordComparator)

        binding.mainRecycler.adapter = adapter
        binding.mainRecycler.layoutManager = LinearLayoutManager(context)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel
                .flow
                .collectLatest { pagingData ->
                    adapter.submitData(pagingData)
                }
        }
    }

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentMainBinding.inflate(inflater, container, false)
}