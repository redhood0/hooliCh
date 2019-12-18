package com.redhood.hoolicalendar.utils;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.alibaba.fastjson.JSON;
import com.redhood.hoolicalendar.WebViewActivity;
import com.redhood.hoolicalendar.utils.ACache;

import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthOschinaRequest;

public class LoginAccessUtil {
    private static String code;
    private static String state;

    /**
     *传入参数，获取用户数据，json格式
     * {"gender":"MALE","nickname":"robot_man","location":"江苏 南京","avatar":"https://static.oschina.net/uploads/user/1854/3708595_50.jpeg?t=1508155510000","source":"OSCHINA","blog":"https://my.oschina.net/u/37xxx08595","uuid":"3708595","email":"17835789-d843-4aa0-8e1f-2b4d44b48e2d","token":{"accessToken":"4673df12-a662-4cc9-8472-1d26bfe6461b","uid":"3708595","expireIn":420125,"refreshToken":"78af8587-6ae6-4fc4-bf5d-4ef221c23b6a"},"username":"robot_man"}
     * @param activity  使用方法所在的activity,需要实现CallBackForUser接口
     * @param username  登陆使用的用户名
     * @param password  登陆使用的密码
     * @param clinetId  用户码，开源中国获取
     * @param secretKey 用户密钥，开源中国获取
     * @param rectUrl   回调地址，开源中国获取
     * @return
     * @Data 2012.12.12
     */
    public static String login(Activity activity, String username, String password, String clinetId, String secretKey, String rectUrl) {

        new Thread(() -> {
            // 创建授权request
            AuthOschinaRequest authRequest =
                    new AuthOschinaRequest(AuthConfig.builder().clientId(clinetId)
                            .clientSecret(secretKey)
                            .redirectUri(rectUrl)
                            .build());
            // 生成授权页面
            String url1 = authRequest.authorize();
            activity.runOnUiThread(() -> {
                WebView myWebView = new WebView(activity);
                myWebView.setWebViewClient(new WebViewClient() {
                    @Override
                    public void onPageFinished(WebView view, String url) {
                        myWebView.evaluateJavascript("javascript:if(document.getElementById('f_email') != null){" +
                                "document.getElementById('f_email').value= '" + username + "';" +
                                "document.getElementById('f_pwd').value= '" + password + "';" +
                                "}" +
                                "document.getElementsByName('authorize')[0].click();", value -> {});
                    }

                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        //监听url的变化，通过比较是否包含回调地址确定是否是包含code的url
                        if (url.contains("www.baidu.com")) {
                            code = Uri.parse(url).getQueryParameter("code");
                            state = Uri.parse(url).getQueryParameter("state");
                            // 构造AuthCallback请求参数，填入code和state
                            AuthCallback callback = new AuthCallback();
                            callback.setCode(code);
                            callback.setState(state);
                            // 开启多线程登录
                            new Thread(() -> {
                                // 通过login方法登录，获得token和用户信息
                                AuthResponse<AuthUser> response = authRequest.login(callback);
                                AuthUser user = response.getData();
                                String userString = JSON.toJSON(user).toString();
                                Log.d("userString",userString);
                                ((CallBackForUser)activity).getUserMsg(userString);
                                Log.e("....", "shouldOverrideUrlLoading: "+ userString );
                                activity.runOnUiThread(() -> {
//                                    String userString = JSON.toJSON(user).toString();
//                                    Cache.get(activity.getApplicationContext()).put("user", userString);
////                                    ACache.get(activity.getApplicationContext()).put("login", "true");A
                                    activity.setResult(998);
                                    activity.finish();
                                });

                            }).start();
                        }
                        return false;
                    }
                });

                // WebView的设置参数类
                WebSettings webSettings = myWebView.getSettings();
                // 让WebView能够执行javaScript
                webSettings.setJavaScriptEnabled(true);
                myWebView.loadUrl(url1);
            });
        }).start();
        return null;
    }
}
