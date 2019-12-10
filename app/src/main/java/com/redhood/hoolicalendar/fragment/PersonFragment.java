package com.redhood.hoolicalendar.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.adapter.MyAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PersonFragment extends Fragment {
    RecyclerView rv_my;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_person, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rv_my = view.findViewById(R.id.rv_my);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        rv_my.setLayoutManager(manager);
        MyAdapter adapter = new MyAdapter();
        rv_my.setAdapter(adapter);
    }
}
