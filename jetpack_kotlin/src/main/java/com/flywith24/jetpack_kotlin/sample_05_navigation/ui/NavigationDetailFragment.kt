package com.flywith24.jetpack_kotlin.sample_05_navigation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.flywith24.jetpack_kotlin.R
import com.flywith24.jetpack_kotlin.common_data.Configs
import com.flywith24.jetpack_kotlin.common_data.bean.Moment
import com.flywith24.jetpack_kotlin.databinding.KotlinFragmentDetailNavigationBinding
import com.flywith24.jetpack_kotlin.sample_04_databinding.ui.state.DetailViewModel
import com.kunminx.architecture.ui.BaseFragment

/**
 * @author Flywith24
 * @date   2020/6/1
 * time   22:06
 * description
 */
class NavigationDetailFragment : BaseFragment() {
    /**
     * fragment-ktx 扩展函数
     */
    private val mDetailViewModel by viewModels<DetailViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.kotlin_fragment_detail_navigation, container, false)
        val binding = KotlinFragmentDetailNavigationBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = mDetailViewModel
        binding.click = ClickProxy()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val moment = arguments?.getParcelable<Moment>(Configs.THIS_MOMENT)
        moment?.let {
            mDetailViewModel.initState(it)
        }
    }

    inner class ClickProxy {
        fun back() {
            nav().navigateUp()
        }
    }
}