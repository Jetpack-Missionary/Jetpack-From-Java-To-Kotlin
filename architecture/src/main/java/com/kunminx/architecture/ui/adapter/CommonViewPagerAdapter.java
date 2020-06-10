

package com.kunminx.architecture.ui.adapter;


import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

/**
 * Create by KunMinX at 19/6/15
 */
public class CommonViewPagerAdapter extends PagerAdapter {

    private final int count;
    private final boolean enableDestroyItem;
    private final String[] title;

    public CommonViewPagerAdapter(int count, boolean enableDestroyItem, String[] title) {
        this.count = count;
        this.enableDestroyItem = enableDestroyItem;
        this.title = title;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return container.getChildAt(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        if (enableDestroyItem) {
            container.removeView((View) object);
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}

