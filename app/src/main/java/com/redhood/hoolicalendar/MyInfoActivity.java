package com.redhood.hoolicalendar;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.redhood.hoolicalendar.bean.MyInformation;
import com.redhood.hoolicalendar.bean.Oauth2Token;
import com.redhood.hoolicalendar.fragment.PersonFragment;
import com.redhood.hoolicalendar.ui.LoadingDialog;
import com.redhood.hoolicalendar.utils.MyDateFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author cky
 * date 2019-12-14
 */
public class MyInfoActivity extends AppCompatActivity {
    TextView tv_title, tv_nick_name, tv_join_time, tv_city, tv_platforms, tv_expertise;
    CircleImageView civ_head;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        init();
    }

    private void init() {
        findViewById(R.id.fl_back).setOnClickListener(v->finish());
        tv_city = findViewById(R.id.tv_city);
        tv_platforms = findViewById(R.id.tv_platforms);
        tv_expertise = findViewById(R.id.tv_expertise);
        tv_join_time = findViewById(R.id.tv_join_time);
        tv_nick_name = findViewById(R.id.tv_nick_name);
        civ_head = findViewById(R.id.civ_head);
        tv_title = findViewById(R.id.tv_title);
        tv_title.setText("我的资料");
        MyInformation myInformation = PersonFragment.myInformation;
        Glide.with(this).load(myInformation.getPortrait()).into(civ_head);
        tv_nick_name.setText(myInformation.getName());
        try {
            tv_join_time.setText(MyDateFormat.stampToTime(MyDateFormat.dateToStamp(myInformation.getJoinTime())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        tv_city.setText(myInformation.getCity());
        tv_platforms.setText(setListToString(myInformation.getPlatforms()));
        tv_expertise.setText(setListToString(myInformation.getExpertise()));
        Log.d("size:",myInformation.getPlatforms().size()+">>>"+myInformation.getExpertise().size());
    }

    private String setListToString(List listToString) {
        StringBuilder result = new StringBuilder("<");

        if (listToString.size() == 0) {
            result.append("无");
        }
        else {
            for (Object array : listToString) {
                result.append(array + "，");
            }
            result = result.deleteCharAt(result.length() - 1);
        }
        result.append(">");

        return result.toString();
    }


}
