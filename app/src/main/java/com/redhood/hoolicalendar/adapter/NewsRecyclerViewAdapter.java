package com.redhood.hoolicalendar.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;


import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.ui.VerticalCenterImageSpan;
import com.redhood.hoolicalendar.util.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<String> news = new ArrayList<>();
    Context context;
    private int ITEM_HEADER = 1, ITEM_CONTENT = 2, ITEM_FOOTER = 3;

    public NewsRecyclerViewAdapter(List<String> news) {
        this.news = news;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        context = parent.getContext();
        if (viewType == ITEM_HEADER) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner, parent, false);
            return new HeadViewHolder(view);
        } else if(viewType == ITEM_CONTENT){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_news, parent, false);
            return new NewsItemViewHolder(view);
        }
        return null;
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            Banner testBanner = ((HeadViewHolder) holder).testBanner;
            testBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
            //设置图片加载器
            testBanner.setImageLoader(new GlideImageLoader());
            //设置图片集合
            List<Integer> images = new ArrayList<>();
            images.add(R.mipmap.banner_test1);
            images.add(R.mipmap.banner_text2);
            images.add(R.mipmap.banner_test3);
            images.add(R.mipmap.banner_test4);

            testBanner.setImages(images);
            //设置指示器位置（当banner模式中有指示器时）
            List<String> titles = new ArrayList<>();
            titles.add("ns国行火热发售");
            titles.add("微软芯片又升级..");
            titles.add("vr游戏新突破");
            titles.add("网易推出水墨风格江湖大作");
            //设置标题集合（当banner样式有显示title时）
            testBanner.setBannerTitles(titles);
            testBanner.setIndicatorGravity(BannerConfig.RIGHT);
            //banner设置方法全部调用完毕时最后调用
            testBanner.start();
        } else {
            NewsItemViewHolder vh = (NewsItemViewHolder) holder;
            SpannableString spString = new SpannableString(" 准备买个全面屏手机，求大家推荐一下11111111111111111");
            Drawable drawable = context.getDrawable(R.mipmap.ic_label_today);
            drawable.setBounds(0, 0, 44, 50);
            ImageSpan imgSpan = new VerticalCenterImageSpan(drawable);
            spString.setSpan(imgSpan, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            vh.tv_news_title.setText(spString);
        }
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ITEM_HEADER;
        }else {
            return ITEM_CONTENT;
        }

    }

    private static class HeadViewHolder extends RecyclerView.ViewHolder {
        Banner testBanner;

        public HeadViewHolder(View itemView) {
            super(itemView);
            testBanner = itemView.findViewById(R.id.testbanner);
        }
    }

    private static class NewsItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_news_title;

        public NewsItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_news_title = itemView.findViewById(R.id.tv_news_title);

        }
    }


}
