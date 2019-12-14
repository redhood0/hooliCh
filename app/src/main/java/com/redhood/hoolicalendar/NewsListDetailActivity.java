package com.redhood.hoolicalendar;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.redhood.hoolicalendar.utils.HttpRequest;

/**
 * @author cky
 * date 2019-12-14
 */
public class NewsListDetailActivity extends AppCompatActivity {
    WebView wv_news;
//    String url = HttpRequest.URL_PRE+
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        init();
    }

    private void init(){
        wv_news = findViewById(R.id.wv_news);
//        wv_news.loadUrl();
    }
}
