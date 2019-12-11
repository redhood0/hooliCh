package com.redhood.hoolicalendar;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @author cky
 * date 2019-12-11
 */
public class MyApplication extends Application {

    private RequestQueue mRequestQueue;

    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mRequestQueue = Volley.newRequestQueue(this);
    }

    public static MyApplication getInstance() {
        return mInstance;
    }

    public static RequestQueue getRequestQueue() {
        return mInstance.mRequestQueue;
    }
}