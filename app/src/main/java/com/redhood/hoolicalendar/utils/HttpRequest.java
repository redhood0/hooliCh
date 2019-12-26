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
 * http请求
 */
public class HttpRequest {
    private static final String TAG = "HttpRequest";
    private static String URL_PRE = "https://www.oschina.net/action";
    private static String TOKEN ="?access_token=4a13c46b-6f45-4a38-9035-4bd8d55b7d0c";

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


}
