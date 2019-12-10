package com.redhood.hoolicalendar.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.util.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<String> news = new ArrayList<>();
    private int ITEM_HEADER = 1, ITEM_CONTENT = 2, ITEM_FOOTER = 3;
    public NewsRecyclerViewAdapter(List<String> news){
        this.news = news;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType == ITEM_HEADER){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner, parent, false);
            return new HeadViewHolder(view);
        }else if(viewType == ITEM_CONTENT){

        }
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my, parent, false);
        return new HeadViewHolder(view);
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(position == 0){
            Banner testBanner = ((HeadViewHolder)holder).testBanner;
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
        }
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return ITEM_HEADER;
        }
        return super.getItemViewType(position);
    }

    static class HeadViewHolder extends RecyclerView.ViewHolder{
        Banner testBanner;

        public HeadViewHolder(View itemView) {
            super(itemView);

            testBanner = itemView.findViewById(R.id.testbanner);
//
//            testBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
//            //设置图片加载器
//            testBanner.setImageLoader(new GlideImageLoader());
//            //设置图片集合
//            List<Integer> images = new ArrayList<>();
//            images.add(R.mipmap.banner_test1);
//            images.add(R.mipmap.banner_text2);
//            images.add(R.mipmap.banner_test3);
//            images.add(R.mipmap.banner_test4);
//
//            testBanner.setImages(images);
//            //设置指示器位置（当banner模式中有指示器时）
//            List<String> titles = new ArrayList<>();
//            titles.add("ns国行火热发售");
//            titles.add("微软芯片又升级..");
//            titles.add("vr游戏新突破");
//            titles.add("网易推出水墨风格江湖大作");
//            //设置标题集合（当banner样式有显示title时）
//            testBanner.setBannerTitles(titles);
//
//            testBanner.setIndicatorGravity(BannerConfig.RIGHT);
//            //banner设置方法全部调用完毕时最后调用
//            testBanner.start();

//            tv_order_status = (TextView)itemView.findViewById(R.id.tv_order_status);
        }
    }
}
