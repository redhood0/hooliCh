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

import com.redhood.hoolicalendar.bean.Oauth2Token;
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

    private String code;
    private String state;
    public static String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        LoginAccessUtil.login(this, "15906288611", "z159q357", "4j04O3p83UCbyRBkE3Ak", "OhDfsfUkAGM3NwmABeT1BhzF44qaqDKj", "https://www.baidu.com/");
    }


    /**
     * 登录账号更换之后 更token
     * @param userJson 用户数据
     */
    @Override
    public void getUserMsg(String userJson) {
        ACache.get(this.getApplicationContext()).put("user", userJson);
        ACache.get(this.getApplicationContext()).put("login", "true");
        Oauth2Token oauth2Token = JSON.parseObject(userJson, Oauth2Token.class);
        token = oauth2Token.getToken().getAccessToken();
        Log.d("token",token);
        ACache.get(this.getApplicationContext()).put("token", token);
        if (!token.equals(ACache.get(this).getAsString("token"))){
            ACache.get(this).remove("token");
            ACache.get(this.getApplicationContext()).put("token", token);
        }
    }
}
