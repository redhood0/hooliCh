package com.redhood.hoolicalendar.utils;

import android.content.Context;
import android.util.Log;


import com.alibaba.fastjson.JSON;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.redhood.hoolicalendar.callback.BeanCallback;

/**
 * @author cky
 * date 2019-12-11
 */
public class HttpRequest {
    private static final String TAG = "HttpRequest";
    public static String URL_PRE = "https://www.oschina.net/action";
    public static String TOKEN ="?access_token=633d045a-c120-4eff-952a-721843db70cb";
    private String newsListUrl = "https://www.oschina.net/action/openapi/news_list?access_token=5f68366f-1f9b-4006-8373-e041550c54b7";
    private String myInformationUrl = "https://www.oschina.net/action/openapi/my_information?access_token=5f68366f-1f9b-4006-8373-e041550c54b7";

    private RequestQueue requestQueue;
    private Context context;
    private BeanCallback callback;

    public HttpRequest(Context context, BeanCallback callback) {
        this.context = context;
        this.callback = callback;
    }

    public void getRequest(String url,String params, Class clazz) {
        requestQueue = Volley.newRequestQueue(context);
        String fullUrl = URL_PRE + url + TOKEN + params;
        Log.d("fullUrl",fullUrl);
        StringRequest stringRequest = new StringRequest(fullUrl, response -> {
            Object o = JSON.parseObject(response, clazz);
            callback.processBeanRequest(o);
        }, error -> {
            Log.e(TAG, error.getMessage(), error);
        });
        requestQueue.add(stringRequest);
    }

    public void getInfoRequest(String url, Class clazz) {
        requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(url, response -> {
            Object o = JSON.parseObject(response, clazz);
            callback.processBeanRequest(o);
        }, error -> {
            Log.e(TAG, error.getMessage(), error);
        });
        requestQueue.add(stringRequest);
    }
    //todo:增加一个post请求的接口参数包含，url，输入json字符串，返回class


}
