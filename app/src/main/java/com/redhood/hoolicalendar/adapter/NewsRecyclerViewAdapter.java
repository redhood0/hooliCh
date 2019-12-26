package com.redhood.hoolicalendar.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;


import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.bean.NewsList;
import com.redhood.hoolicalendar.ui.VerticalCenterImageSpan;
import com.redhood.hoolicalendar.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<NewsList.NewslistBean> news;
    Context context;
    private int ITEM_HEADER = 1, ITEM_CONTENT = 2, ITEM_FOOTER = 3;
    Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public NewsRecyclerViewAdapter(List<NewsList.NewslistBean> news) {
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
            SpannableString spString = new SpannableString(" " + news.get(position).getTitle());

            //bitmap缩放
            Bitmap little_icon = BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_label_today);
            Matrix matrix = new Matrix();
            matrix.postScale(1f,1f);
            Bitmap resize_icon = Bitmap.createBitmap(little_icon,0,0,little_icon.getWidth(),little_icon.getHeight(),matrix,true);

            Canvas canvas = new Canvas();
            Bitmap bg = Bitmap.createBitmap(70,70,Bitmap.Config.ARGB_8888);
            canvas.setBitmap(bg);

            canvas.drawBitmap(resize_icon,0,4,null);
            Drawable newDrawable = new BitmapDrawable(context.getResources(),bg);
            newDrawable.setBounds(0,0,70,70);
            ImageSpan imgSpan = new VerticalCenterImageSpan(newDrawable);

            spString.setSpan(imgSpan, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

            vh.tv_news_title.setText(spString);
            vh.tv_author.setText(news.get(position).getAuthor());
//            vh.tv_content.setText();

//            vh.tv_news_title.setCompoundDrawablePadding(40);

            //item点击事件
            vh.itemView.setOnClickListener(v->{
                if (callback != null){
                    callback.onItemClick(v,position);
                }
            });



//
//            vh.tv_news_title.setOnTouchListener(new View.OnTouchListener() {
//
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//                    Log.e("ss", "onBindViewHolder: ssss" );
//                    return true;
//                }
//            });
//
//            vh.cs_news.setOnClickListener(v->{
//                if (callback != null){
//                    callback.onItemClick(vh.itemView,position);
//                }
//            });

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
        TextView tv_news_title,tv_content,tv_author;
        ConstraintLayout cs_news;
        public NewsItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_news_title = itemView.findViewById(R.id.tv_news_title);
            tv_content = itemView.findViewById(R.id.tv_content);
            tv_author = itemView.findViewById(R.id.tv_author);
            cs_news = itemView.findViewById(R.id.cs_news);
        }
    }

    /**
     * 将Drawable转换为Bitmap
     * @param drawable
     * @return
     */
    private Bitmap drawableToBitmap(Drawable drawable) {
        //取drawable的宽高
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        //取drawable的颜色格式
        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE
                ? Bitmap.Config.ARGB_8888
                : Bitmap.Config.RGB_565;
        //创建对应的bitmap
        Bitmap bitmap = Bitmap.createBitmap(width, height, config);
        //创建对应的bitmap的画布
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        //把drawable内容画到画布中
        drawable.draw(canvas);
        return bitmap;
    }

    public interface Callback{
        void onItemClick(View v, int position);
    }
}
