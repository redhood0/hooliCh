package com.redhood.hoolicalendar.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.adapter.MyPagerAdapter;
import com.redhood.hoolicalendar.ui.LoadingDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

/**
 * @author cky
 * date 2019-12-15
 */
public class TweetFragment extends Fragment {
    TabLayout tabs_tweet;
    ViewPager vp_tweet;
    private String[] tabNames = {"最新", "热门", "话题", "我的"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tweet,container,false);
        init(view);
        return view;
    }

    private void init(View view){
        tabs_tweet = view.findViewById(R.id.tabs_tweet);
        vp_tweet = view.findViewById(R.id.vp_tweet);

        PagerAdapter pagerAdapter = new MyPagerAdapter(getChildFragmentManager(),BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
                ,addFragment());
        vp_tweet.setAdapter(pagerAdapter);
        tabs_tweet.setupWithViewPager(vp_tweet);
        for (int i = 0; i < tabNames.length; i++) {
            tabs_tweet.getTabAt(i).setText(tabNames[i]);
        }
    }

    private List<Fragment> addFragment(){
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new TweetNewFragment());
        fragments.add(new TweetHotFragment());
        fragments.add(new TweetTalkFragment());
        fragments.add(new TweetMyFragment());
        return fragments;
    }
}
