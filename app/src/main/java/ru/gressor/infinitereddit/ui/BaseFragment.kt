package ru.gressor.infinitereddit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B : ViewBinding> : Fragment() {
    private var _binding: B? = null
    protected val binding: B get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = 
        getBinding(inflater, container)
            .also { _binding = it }
            .root

    abstract fun getBinding(inflater: LayoutInflater, container: ViewGroup?): B

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}