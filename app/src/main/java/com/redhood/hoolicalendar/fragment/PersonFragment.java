package com.redhood.hoolicalendar.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.redhood.hoolicalendar.LoginActivity;
import com.redhood.hoolicalendar.MyMessageActivity;
import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.SettingActivity;
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

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonFragment extends Fragment implements View.OnClickListener, MyAdapter.OnItemClickListener, BeanCallback {
    RecyclerView rv_my;
    CircleImageView cv_head;
    TextView tv_name;
    FrameLayout fl_setting, fl_grcode;
    public static MyInformation myInformation;
    public static String user;

    public static String myinformationurl = "https://www.oschina.net/action/openapi/my_information?access_token=";
    private final String ORIGINURL = "https://www.oschina.net/action/openapi/my_information?access_token=";


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
        fl_setting = view.findViewById(R.id.fl_setting);
        fl_grcode = view.findViewById(R.id.fl_grcode);
        cv_head.setOnClickListener(this);
        fl_setting.setOnClickListener(this);


        String url = ACache.get(getActivity()).getAsString("url")+"";
//        myinformationurl = url;
        Log.w("url",url);
        if (!url.equals("null")){
            myinformationurl = url;
        }

        user = ACache.get(getActivity()).getAsString("user");
        Log.d("user", ACache.get(getActivity()).getAsString("user") + "");
        if (myInformation == null && user != null&&!myinformationurl.equals(ORIGINURL)) {
            new HttpRequest(getContext(), this).getRequest(myinformationurl, MyInformation.class);
        }
        if (myInformation != null) {
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
    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext()).setTitle("选择操作").setItems(new String[]{"更换头像", "查看大头像"}, (dialogInterface, i) -> {
            switch (i) {
                case 0:
                    Toast.makeText(getContext(), "" + 0, Toast.LENGTH_SHORT).show();

                    break;
                case 1:
                    Toast.makeText(getContext(), "" + 1, Toast.LENGTH_SHORT).show();

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
                if (myInformation == null)
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                else showDialog();
                break;
            case R.id.fl_setting:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
        }
    }

    @Override
    public void onItemClick(View v, int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(getActivity(), MyMessageActivity.class));
                break;

        }
    }


    @Override
    public void processBeanRequest(Object bean) {
        myInformation = (MyInformation) bean;
        Log.e("eee", bean.toString());
    }

    @Override
    public void onResume() {
        super.onResume();
        if (WebViewActivity.token == null){
            myinformationurl += "";
        } else if (myinformationurl.length()<=68){
            myinformationurl += WebViewActivity.token;
            ACache.get(getActivity()).put("url",myinformationurl);
            Log.e("myinformationurl",myinformationurl);
        }

        if (myInformation == null) {
            cv_head.setImageResource(R.mipmap.widget_default_face);
            tv_name.setText("点击头像登录");
        }
        if (user == null)
            user = ACache.get(getActivity()).getAsString("user");
        if (myInformation == null && user != null) {
            new HttpRequest(getContext(), bean -> {
                myInformation = (MyInformation) bean;
                Glide.with(getContext()).load(myInformation.getPortrait()).into(cv_head);
                tv_name.setText(myInformation.getName());
            }).getRequest(myinformationurl, MyInformation.class);
        }
    }


}
