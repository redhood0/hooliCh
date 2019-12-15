package com.redhood.hoolicalendar;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.redhood.hoolicalendar.fragment.PersonFragment;
import com.redhood.hoolicalendar.utils.ACache;

/**
 * @author cky
 * date 2019-12-12
 */
public class SettingActivity extends Activity implements View.OnClickListener {
    ConstraintLayout cl_logout;
    TextView tv_title;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        init();
    }

    private void init(){
        findViewById(R.id.fl_back).setOnClickListener(v->finish());
        cl_logout = findViewById(R.id.cl_logout);
        tv_title = findViewById(R.id.tv_title);
        tv_title.setText("设置");
        cl_logout.setOnClickListener(this);
        if (PersonFragment.myInformation == null){
            cl_logout.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cl_logout:
                ACache.get(this).remove("user");
                PersonFragment.myInformation = null;
                PersonFragment.user = null;
                ACache.get(this).remove("url");
                cl_logout.setVisibility(View.INVISIBLE);
                break;
        }
    }
}
