package com.redhood.hoolicalendar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.redhood.hoolicalendar.utils.ImmersiveStatusBarSettings;


public class ForgetPwdActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tv_navigation_label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd);

        new ImmersiveStatusBarSettings().settingStatusBar(this);
        tv_navigation_label = findViewById(R.id.tv_navigation_label);
        tv_navigation_label.setText("找回密码");
        findViewById(R.id.ib_navigation_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_navigation_back:
                finish();
                break;
        }
    }
}
