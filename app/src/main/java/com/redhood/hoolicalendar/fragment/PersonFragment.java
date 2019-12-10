package com.redhood.hoolicalendar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.redhood.hoolicalendar.LoginActivity;
import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.adapter.MyAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonFragment extends Fragment implements View.OnClickListener, MyAdapter.OnItemClickListener {
    RecyclerView rv_my;
    CircleImageView cv_head;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_person, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rv_my = view.findViewById(R.id.rv_my);
        cv_head = view.findViewById(R.id.cv_head);
        cv_head.setOnClickListener(this);
        setAdapter();

    }

    private void setAdapter() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        MyAdapter adapter = new MyAdapter();
        rv_my.setLayoutManager(manager);
        rv_my.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cv_head:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
        }
    }

    @Override
    public void onItemClick(View v, int position) {
        Toast.makeText(getContext(), "" + position, Toast.LENGTH_SHORT).show();

    }
}
