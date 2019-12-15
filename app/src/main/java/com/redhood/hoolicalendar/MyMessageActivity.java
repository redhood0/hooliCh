package com.redhood.hoolicalendar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.redhood.hoolicalendar.adapter.QuickFragmentPageAdapter;
import com.redhood.hoolicalendar.fragment.EmptyFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cky
 * date 2019-12-12
 */
public class MyMessageActivity extends AppCompatActivity {
    TextView tv_title;
    ViewPager vp;
    private String[] titles = new String[]{"@我","评论","私信"};
    TabLayout tab;
    QuickFragmentPageAdapter adapter;
    private List<EmptyFragment> fragmentList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_message);
        init();
    }

    private void init(){
        findViewById(R.id.fl_back).setOnClickListener(v->finish());
        vp = findViewById(R.id.vp);
        tab = findViewById(R.id.tab);
        tv_title = findViewById(R.id.tv_title);
        tv_title.setText("消息中心");
        fragmentList = new ArrayList<>();

        for (int i = 0; i < titles.length; i++) {
            tab.addTab(tab.newTab());

            fragmentList.add(new EmptyFragment());
        }

        adapter = new QuickFragmentPageAdapter(getSupportFragmentManager(),fragmentList);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
        for (int i = 0; i < titles.length; i++) {
            tab.getTabAt(i).setText(titles[i]);
        }
    }
}
