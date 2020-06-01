package com.flywith24.jetpack_kotlin.sample_05_navigation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.flywith24.jetpack_kotlin.R
import com.flywith24.jetpack_kotlin.databinding.KotlinFragmentEditorNavigationBinding
import com.flywith24.jetpack_kotlin.sample_04_databinding.ui.state.EditorViewModel
import com.flywith24.jetpack_kotlin.sample_05_navigation.ui.callback.SharedViewModel
import com.kunminx.architecture.ui.BaseFragment

/**
 * @author Flywith24
 * @date   2020/6/1
 * time   22:04
 * description
 */
class NavigationEditorFragment : BaseFragment() {
    /**
     * fragment 级别共享 ViewModel
     */
    private val mEditorViewModel by viewModels<EditorViewModel>()

    /**
     * activity 级别共享 ViewModel
     */
    private val mShareViewModel by activityViewModels<SharedViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.kotlin_fragment_editor_navigation, container, false)
        val binding = KotlinFragmentEditorNavigationBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = mEditorViewModel
        binding.click = ClickProxy()
        return view
    }

    inner class ClickProxy : Toolbar.OnMenuItemClickListener {
        fun locate() {
            nav().navigate(R.id.action_editorFragment_Navigation_to_locationFragment_Navigation)
        }

        fun addPic() {

        }

        fun back() {
            nav().navigateUp()
        }

        override fun onMenuItemClick(item: MenuItem?): Boolean {
            when (item?.itemId) {
                R.id.menu_save -> {

                }
            }
            return true
        }


    }
}