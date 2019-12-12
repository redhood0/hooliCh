package com.redhood.hoolicalendar.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.redhood.hoolicalendar.LoginActivity;
import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.WebViewActivity;
import com.redhood.hoolicalendar.adapter.MyAdapter;
import com.redhood.hoolicalendar.bean.MyInformation;
import com.redhood.hoolicalendar.callback.BeanCallback;
import com.redhood.hoolicalendar.utils.ACache;
import com.redhood.hoolicalendar.utils.HttpRequest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonFragment extends Fragment implements View.OnClickListener, MyAdapter.OnItemClickListener, BeanCallback {
    RecyclerView rv_my;
    CircleImageView cv_head;
    TextView tv_name;
    ImageView iv_setting;
    public static MyInformation myInformation;
    String user;
    HttpRequest httpRequest;

    private static final String MYINFORMATIONURL = "https://www.oschina.net/action/openapi/my_information?access_token=5f68366f-1f9b-4006-8373-e041550c54b7";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_person, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        init(view);
        setAdapter();

    }

    private void init(View view) {
        rv_my = view.findViewById(R.id.rv_my);
        cv_head = view.findViewById(R.id.cv_head);
        tv_name = view.findViewById(R.id.tv_name);
        iv_setting = view.findViewById(R.id.iv_setting);
        cv_head.setOnClickListener(this);
        iv_setting.setOnClickListener(this);

        user = ACache.get(getActivity()).getAsString("user");

            Log.d("user",ACache.get(getActivity()).getAsString("user")+"");


        if (myInformation == null && user != null) {
            new HttpRequest(getContext(), this).getRequest(MYINFORMATIONURL, MyInformation.class);
        }

        if (myInformation != null){
            Glide.with(getContext()).load(myInformation.getPortrait()).into(cv_head);
            tv_name.setText(myInformation.getName());

        }
    }

    private void setAdapter() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        MyAdapter adapter = new MyAdapter();
        rv_my.setLayoutManager(manager);
        rv_my.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    //todo 更换头像、查看大头像
    private void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext()).setTitle("选择操作").setItems(new String[]{"更换头像","查看大头像"}, (dialogInterface, i) -> {
            switch (i){
                case 0:
                    Toast.makeText(getContext(), ""+0, Toast.LENGTH_SHORT).show();

                    break;
                case 1:
                    Toast.makeText(getContext(), ""+1, Toast.LENGTH_SHORT).show();

                    break;

            }
        }).setPositiveButton("取消", (dialogInterface, i) -> {

        });
        builder.create().show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cv_head:
                if (myInformation==null) startActivity(new Intent(getActivity(), LoginActivity.class));
                else showDialog();
                break;
            case R.id.iv_setting:
                ACache.get(getActivity()).remove("user");
                myInformation = null;
                break;
        }
    }

    @Override
    public void onItemClick(View v, int position) {
        Toast.makeText(getContext(), "" + position, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void processBeanRequest(Object bean) {
        myInformation = (MyInformation) bean;
        Log.e("eee", bean.toString());
    }

    @Override
    public void onResume() {
        super.onResume();
        if (user == null)
        user = ACache.get(getActivity()).getAsString("user");
        if (myInformation == null && user != null) {
            new HttpRequest(getContext(), bean -> {
                myInformation = (MyInformation) bean;
                Glide.with(getContext()).load(myInformation.getPortrait()).into(cv_head);
                tv_name.setText(myInformation.getName());
            }).getRequest(MYINFORMATIONURL, MyInformation.class);
        }
    }


}
