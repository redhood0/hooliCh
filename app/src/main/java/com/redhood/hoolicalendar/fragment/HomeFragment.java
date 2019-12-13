package com.redhood.hoolicalendar.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.android.material.tabs.TabLayout;
import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class HomeFragment extends Fragment {
    TabLayout tabs_home;
    ViewPager viewpage_home;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        initCompents(v);
        return v;
    }

    private void initCompents(View v) {
        viewpage_home = v.findViewById(R.id.viewpage_home);
        tabs_home = v.findViewById(R.id.tabs_home);

        String[] tabNames = {"关注", "软件", "资讯", "推荐", "问答"};


        tabs_home.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.i("tabs","onTabSelected:"+tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new RelationAdvFragment());
        fragments.add(new HomeSoftWareFragment());
        fragments.add(new NewsFragment());
        fragments.add(new PersonFragment());
        fragments.add(new PersonFragment());

        PagerAdapter pagerAdapter = new MyPagerAdapter(getChildFragmentManager(),BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
                ,fragments);
        viewpage_home.setAdapter(pagerAdapter);

        tabs_home.setupWithViewPager(viewpage_home);
//        tabs_home.addTab(tabs_home.newTab().setText("关注"));
//        tabs_home.addTab(tabs_home.newTab().setText("软件"));
//        tabs_home.addTab(tabs_home.newTab().setText("资讯"));
//        tabs_home.addTab(tabs_home.newTab().setText("推荐"));
//        tabs_home.addTab(tabs_home.newTab().setText("问答"));
        tabs_home.getTabAt(2).select();

        for (int i = 0; i < tabNames.length; i++) {
            tabs_home.getTabAt(i).setText(tabNames[i]);
        }
    }


}
