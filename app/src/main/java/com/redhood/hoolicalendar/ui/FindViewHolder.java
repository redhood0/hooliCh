package com.redhood.hoolicalendar.ui;

import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.bean.FindBannerData;
import com.zhpan.bannerview.holder.ViewHolder;

public class FindViewHolder implements ViewHolder<FindBannerData> {
    Fragment fragment;
    public FindViewHolder(Fragment fragment){
        this.fragment = fragment;
    }
    @Override
    public int getLayoutId() {
        return R.layout.item_banner_find;
    }

    @Override
    public void onBind(View itemView, FindBannerData data, int position, int size) {
        ImageView imageView = itemView.findViewById(R.id.banner_img);
        Glide.with(fragment)
                .load(data.getImgId())
                .into(imageView);
    }
}
