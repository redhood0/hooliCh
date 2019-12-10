package com.redhood.hoolicalendar.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.redhood.hoolicalendar.R;

/**
 * @author cky
 * date 2019-12-10
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private int[] imgs ={R.mipmap.ic_my_message,R.mipmap.ic_my_badge,R.mipmap.ic_my_profile,
            R.mipmap.ic_my_blog,R.mipmap.ic_my_blacklist,R.mipmap.ic_my_question,
            R.mipmap.ic_my_publish,R.mipmap.ic_my_event,R.mipmap.ic_my_tags,R.mipmap.ic_my_recommend};
    private String[] tvs = {"我的消息","我的勋章","阅读记录","我的博客","我的灰名单","我的问答","我的投递","我的活动","关注标签","邀请好友"};
    private OnItemClickListener onItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.iv_left.setImageResource(imgs[position]);
        holder.tv_my.setText(tvs[position]);
        holder.iv_arrow.setImageResource(R.mipmap.ic_arrow_right);

        holder.itemView.setOnClickListener(v->{
            if (onItemClickListener!=null)
                onItemClickListener.onItemClick(v,position);
        });



    }

    @Override
    public int getItemCount() {
        return imgs.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_left,iv_arrow;
        TextView tv_my;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_left  = itemView.findViewById(R.id.iv_left);
            iv_arrow  = itemView.findViewById(R.id.iv_arrow);
            tv_my  = itemView.findViewById(R.id.tv_my);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View v, int position);
    }
}
