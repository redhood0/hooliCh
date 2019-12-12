package com.redhood.hoolicalendar.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.adapter.NewsRecyclerViewAdapter;
import com.redhood.hoolicalendar.bean.MyInformation;
import com.redhood.hoolicalendar.bean.NewsList;
import com.redhood.hoolicalendar.callback.BeanCallback;
import com.redhood.hoolicalendar.utils.HttpRequest;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NewsFragment extends Fragment implements BeanCallback {

    RecyclerView recyclerView;
    private final static String NEWSLISTURL = "https://www.oschina.net/action/openapi/news_list?access_token=5f68366f-1f9b-4006-8373-e041550c54b7";
    NewsRecyclerViewAdapter adapter;
    List<NewsList.NewslistBean> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_new, container, false);

        recyclerView = v.findViewById(R.id.rv_home_news);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));

        new HttpRequest(getContext(), this).getRequest(NEWSLISTURL, NewsList.class);
        Log.d("ee",""+list);


        return v;
    }

    @Override
    public void processBeanRequest(Object bean) {
        list = ((NewsList) bean).getNewslist();
        adapter = new NewsRecyclerViewAdapter(list);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }
}
