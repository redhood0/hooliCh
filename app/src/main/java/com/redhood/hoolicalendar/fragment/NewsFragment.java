package com.redhood.hoolicalendar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.redhood.hoolicalendar.NewsListDetailActivity;
import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.adapter.NewsRecyclerViewAdapter;
import com.redhood.hoolicalendar.bean.MyInformation;
import com.redhood.hoolicalendar.bean.NewsList;
import com.redhood.hoolicalendar.bean.ProgremsBean;
import com.redhood.hoolicalendar.callback.BeanCallback;
import com.redhood.hoolicalendar.ui.LoadingDialog;
import com.redhood.hoolicalendar.utils.HttpRequest;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NewsFragment extends Fragment implements BeanCallback,NewsRecyclerViewAdapter.Callback{

    RecyclerView recyclerView;
    private final static String NEWSLISTURL = "/openapi/news_list";
    NewsRecyclerViewAdapter adapter;
    List<NewsList.NewslistBean> list;
    LoadingDialog loadingDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_new, container, false);
        loadingDialog = new LoadingDialog(getContext(),R.style.MyDialogStyle);
        loadingDialog.setLoadingBg(R.color.bg_3E8146);
        loadingDialog.show();
        recyclerView = v.findViewById(R.id.rv_home_news);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));

        new HttpRequest(getContext(), this).getRequest(NEWSLISTURL,"", NewsList.class);

        return v;
    }

    @Override
    public void processBeanRequest(Object bean) {
        list = ((NewsList) bean).getNewslist();
        adapter = new NewsRecyclerViewAdapter(list);
        adapter.notifyDataSetChanged();
        adapter.setCallback(this);
        recyclerView.setAdapter(adapter);
        loadingDialog.dismiss();
    }

    @Override
    public void onItemClick(View v, int position) {
        Toast.makeText(getContext(), ""+position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), NewsListDetailActivity.class);
        int newsId = list.get(position).getId();
        intent.putExtra("newId",newsId);
        startActivity(intent);
    }
}
