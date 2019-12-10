package com.redhood.hoolicalendar.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.adapter.MyAdapter;
import com.redhood.hoolicalendar.adapter.NewsRecyclerViewAdapter;
import com.redhood.hoolicalendar.util.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NewsFragment extends Fragment {

    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_new,container,false);

        recyclerView = v.findViewById(R.id.rv_home_news);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        List<String> strs = new ArrayList<>();
        strs.add("1");
        strs.add("2");
        recyclerView.setAdapter(new NewsRecyclerViewAdapter(strs));


        return v;
    }
}
