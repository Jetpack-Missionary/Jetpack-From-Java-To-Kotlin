

package com.kunminx.jetpack_java.sample_05_navigation.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kunminx.jetpack_java.R;
import com.kunminx.jetpack_java.common_data.Configs;
import com.kunminx.jetpack_java.common_data.bean.Moment;
import com.kunminx.jetpack_java.databinding.FragmentDetailNavigationBinding;
import com.kunminx.jetpack_java.sample_04_databinding.ui.state.DetailViewModel;
import com.kunminx.architecture.ui.BaseFragment;

/**
 * Create by KunMinX at 2020/5/30
 */
public class NavigationDetailFragment extends BaseFragment {

    private DetailViewModel mDetailViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDetailViewModel = getFragmentViewModel(DetailViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_navigation, container, false);
        FragmentDetailNavigationBinding binding = FragmentDetailNavigationBinding.bind(view);
        binding.setLifecycleOwner(this);
        binding.setVm(mDetailViewModel);
        binding.setClick(new ClickProxy());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Moment moment = (Moment) getArguments().getParcelable(Configs.THIS_MOMENT);
        mDetailViewModel.initState(moment);
    }

    public class ClickProxy {
        public void back() {
            nav().navigateUp();
        }
    }
}
