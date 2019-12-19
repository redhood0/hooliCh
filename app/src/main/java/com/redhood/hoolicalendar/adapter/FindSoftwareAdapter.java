package com.redhood.hoolicalendar.adapter;

import android.graphics.ColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.bean.FindSoftwareBean;

import java.util.List;
import java.util.zip.Inflater;

import jp.wasabeef.glide.transformations.ColorFilterTransformation;

public class FindSoftwareAdapter extends RecyclerView.Adapter<FindSoftwareAdapter.VH> {

    List<FindSoftwareBean> datas;
    Fragment fg;

    public FindSoftwareAdapter(List<FindSoftwareBean> datas, Fragment fg) {
        this.datas = datas;
        this.fg = fg;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_find_software,parent,false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        ImageView imageView = holder.iv_bg;
        int imgId = datas.get(position).getImgId();
        Glide.with(fg)
                .load(imgId)
                .transform(new MultiTransformation<>(new ColorFilterTransformation(0x79000000),new CenterCrop(),new RoundedCorners(8)))
//                .apply(RequestOptions.bitmapTransform(new RoundedCorners(2000)))
                .into(imageView);
        holder.tv_title.setText(datas.get(position).getTitle());
        holder.tv_content.setText(datas.get(position).getContent());


    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class VH extends RecyclerView.ViewHolder{
        TextView tv_content;
        TextView tv_title;
        ImageView iv_bg;

        public VH(@NonNull View itemView) {
            super(itemView);
            tv_content = itemView.findViewById(R.id.tv_content);
            tv_title = itemView.findViewById(R.id.tv_title);
            iv_bg = itemView.findViewById(R.id.iv_bg);
        }
    }
}
