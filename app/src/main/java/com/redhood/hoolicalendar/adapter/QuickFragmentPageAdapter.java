package com.redhood.hoolicalendar.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * @author cky
 * date 2019-11-01
 */
public class QuickFragmentPageAdapter<T extends Fragment> extends FragmentStatePagerAdapter {
    private List<T> list;

    public QuickFragmentPageAdapter(FragmentManager fm, List<T> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
