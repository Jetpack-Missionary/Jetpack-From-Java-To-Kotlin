package com.flywith24.jetpack_kotlin.sample_05_navigation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.flywith24.jetpack_kotlin.R
import com.flywith24.jetpack_kotlin.base.Event
import com.flywith24.jetpack_kotlin.databinding.KotlinFragmentLocationNavigationBinding
import com.flywith24.jetpack_kotlin.sample_02_livedata.domain.LiveDataLocationManager
import com.flywith24.jetpack_kotlin.sample_04_databinding.ui.adapter.DataBindingLocationAdapter
import com.flywith24.jetpack_kotlin.sample_04_databinding.ui.state.LocationViewModel
import com.flywith24.jetpack_kotlin.sample_05_navigation.ui.callback.SharedViewModel
import com.kunminx.architecture.ui.BaseFragment

/**
 * @author Flywith24
 * @date   2020/6/1
 * time   22:01
 * description
 */
class NavigationLocationFragment : BaseFragment() {

    private val mLocationViewModel by viewModels<LocationViewModel>()
    private val mSharedViewModel by activityViewModels<SharedViewModel>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.kotlin_fragment_location_navigation, container, false)
        val binding = KotlinFragmentLocationNavigationBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = mLocationViewModel
        binding.adapter = DataBindingLocationAdapter(requireContext()).apply {
            setOnItemClickListener { item, _ ->
                mSharedViewModel.location.value = Event(item.locationName)
                nav().navigateUp()
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycle.addObserver(LiveDataLocationManager.getInstance())

        LiveDataLocationManager.getInstance().getLocationBeans().observe(viewLifecycleOwner) { locationBeans ->
            mLocationViewModel.list.value = locationBeans
        }
    }
}