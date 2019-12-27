package com.redhood.hoolicalendar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.redhood.hoolicalendar.bean.NewsDetail;
import com.redhood.hoolicalendar.callback.BeanCallback;
import com.redhood.hoolicalendar.ui.LoadingDialog;
import com.redhood.hoolicalendar.utils.HttpRequest;
import com.redhood.hoolicalendar.utils.ImmersiveStatusBarSettings;

/**
 * @author cky
 * date 2019-12-14
 * 新闻细节
 */
public class NewsListDetailActivity extends AppCompatActivity implements BeanCallback {
    WebView wv_news;
    LoadingDialog loadingDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        ImmersiveStatusBarSettings.setAndroidNativeLightStatusBar(this,true);
        init();
    }

    private void init(){
        wv_news = findViewById(R.id.wv_news);

        loadingDialog = new LoadingDialog(this,R.style.MyDialogStyle);
        loadingDialog.setLoadingBg(R.color.bg_3E8146);
        loadingDialog.show();
        Intent intent = getIntent();
        int newId = intent.getIntExtra("newId", 0);
        new HttpRequest(this,this).getRequest("/openapi/news_detail","&id="+newId, NewsDetail.class);
    }

    @Override
    public void processBeanRequest(Object bean) {
        String url = ((NewsDetail) bean).getUrl();
        wv_news.loadUrl(url);
        wv_news.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                loadingDialog.dismiss();
            }
        });

    }
}
