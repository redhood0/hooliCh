package com.redhood.hoolicalendar;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;

import com.redhood.hoolicalendar.utils.ACache;
import com.redhood.hoolicalendar.utils.CallBackForUser;
import com.redhood.hoolicalendar.utils.LoginAccessUtil;

import java.io.IOException;

import androidx.core.view.ViewCompat;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthOschinaRequest;


public class WebViewActivity extends AppCompatActivity implements CallBackForUser {
    private WebView webView;
    private String code;
    private String state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = findViewById(R.id.web_view);
//
        LoginAccessUtil.login(this,"15906288611","z159q357","wvNfVJCvSKXPT2SCrsCG","EM4JUtta9ykQxny0kHHBxjTwntjflWe8","https://www.baidu.com/");
    }

//这里使用user
    @Override
    public void getUserMsg(String userJson) {
        Log.e("ssss", "getUserMsg: "+userJson );
    }
}
