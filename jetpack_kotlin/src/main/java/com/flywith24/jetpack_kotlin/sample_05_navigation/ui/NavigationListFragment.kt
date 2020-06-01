package com.flywith24.jetpack_kotlin.sample_05_navigation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.flywith24.jetpack_kotlin.R
import com.flywith24.jetpack_kotlin.databinding.KottlinFragmentListNavigationBinding
import com.flywith24.jetpack_kotlin.sample_04_databinding.ui.state.ListViewModel
import com.kunminx.architecture.ui.BaseFragment

/**
 * @author Flywith24
 * @date   2020/6/1
 * time   22:02
 * description
 */
class NavigationListFragment : BaseFragment() {

    private val mListViewModel by viewModels<ListViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.kottlin_fragment_list_navigation, container, false)
        val binding = KottlinFragmentListNavigationBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = mListViewModel
        binding.click = ClickProxy()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mListViewModel.getListMutableLiveData().observe(viewLifecycleOwner) { moments ->
            mListViewModel.list.value = moments
        }

        mListViewModel.requestList()
    }


    inner class ClickProxy {
        fun fabClick() {
            nav().navigate(R.id.action_listFragment_Navigation_to_editorFragment_Navigation)
        }
    }
}