package com.redhood.hoolicalendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.redhood.hoolicalendar.utils.ImmersiveStatusBarSettings;

/**
 * @author cky
 * date 2019-12-12
 * 启动页面
 */
public class LaunchViewActivity extends Activity {

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            startActivity(new Intent(LaunchViewActivity.this,MainActivity.class));
            finish();
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_view);
        new ImmersiveStatusBarSettings().settingStatusBar(this);
        handler.sendEmptyMessageDelayed(0,1000);
    }
}
