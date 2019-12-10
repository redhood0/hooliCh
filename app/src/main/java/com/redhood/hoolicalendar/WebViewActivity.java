package com.redhood.hoolicalendar;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.redhood.hoolicalendar.utils.ACache;

import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthOschinaRequest;


public class WebViewActivity extends AppCompatActivity{
    private WebView webView;
    private String code;
    private String state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.web_view);

        new Thread(() -> {
            // 创建授权request
            AuthOschinaRequest authRequest =
                    new AuthOschinaRequest(AuthConfig.builder().clientId(
                            "wvNfVJCvSKXPT2SCrsCG").clientSecret(
                            "EM4JUtta9ykQxny0kHHBxjTwntjflWe8")
                            .redirectUri("https://www.baidu.com/")
                            .build());
            // 生成授权页面
            String url1 = authRequest.authorize();
            runOnUiThread(() -> {
                webView.setWebViewClient(new WebViewClient() {

//                            @Override
//                            public void onPageFinished(WebView view,
//                                                       String url) {
//                                super.onPageFinished(view, url);
//                                if (url.equals(url1)) {
//                                    String js = "javascript:document" +
//                                                        ".getElementById" +
//                                                        "('f_email').value " +
//                                                        "='119651013@qq.com';" +
//                                                        "document" +
//                                                        ".getElementById" +
//                                                        "('f_pwd').value = " +
//                                                        "'w880223c***';var " +
//                                                        "frms=document" +
//                                                        ".getElementById" +
//                                                        "('frm_approve')" +
//                                                        ".submit();";
//
//                                    webView.evaluateJavascript(js,
//                                            new ValueCallback<String>() {
//                                                @Override
//                                                public void onReceiveValue(String value) {
//
//                                                }
//                                            });
//                                }
//                            }

                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        //监听url的变化，通过比较是否包含回调地址确定是否是包含code的url
                        if (url.contains("www.baidu.com")) {
                            code = Uri.parse(url).getQueryParameter(
                                    "code");
                            state = Uri.parse(url).getQueryParameter(
                                    "state");
                            // 构造AuthCallback请求参数，填入code和state
                            AuthCallback callback = new AuthCallback();
                            callback.setCode(code);
                            callback.setState(state);
                            // 开启多线程登录
                            new Thread(() -> {
                                // 通过login方法登录，获得token和用户信息
                                AuthResponse<AuthUser> response =
                                        authRequest.login(callback);
                                AuthUser user = response.getData();
                                runOnUiThread(() -> {
                                    String userString =
                                            JSON.toJSON(user).toString();
                                    ACache.get(WebViewActivity.this).put("user", userString);
                                    ACache.get(WebViewActivity.this).put("login", "true");
                                    setResult(998);
                                    finish();
                                });
                            }).start();
                        }
                        return false;
                    }
                });

                // WebView的设置参数类
                WebSettings webSettings = webView.getSettings();
                // 让WebView能够执行javaScript
                webSettings.setJavaScriptEnabled(true);
                // 通过Webiew记载授权界面
                webView.loadUrl(url1);


            });
        }).start();

    }


}
