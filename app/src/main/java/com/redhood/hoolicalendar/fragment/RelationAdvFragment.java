package com.redhood.hoolicalendar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.redhood.hoolicalendar.LoginActivity;
import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.utils.ACache;

import java.io.FileNotFoundException;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

public class RelationAdvFragment extends Fragment {
    ConstraintLayout clayout_login_check;
    Button btn_to_login;
    TextView tv_loging_notice;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_relation_adv, container, false);
        clayout_login_check = view.findViewById(R.id.clayout_login_check);
        btn_to_login = view.findViewById(R.id.btn_to_login);
        tv_loging_notice = view.findViewById(R.id.tv_loging_notice);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(ACache.get(getContext()).getAsString("user") != null){
            btn_to_login.setVisibility(View.INVISIBLE);
            tv_loging_notice.setText("暂时没有新动态");
        }
        btn_to_login.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });
    }
}
