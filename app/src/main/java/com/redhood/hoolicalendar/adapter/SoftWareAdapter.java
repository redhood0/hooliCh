package com.redhood.hoolicalendar.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.bean.ProgremsBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SoftWareAdapter extends RecyclerView.Adapter<SoftWareAdapter.VH> {
    List<ProgremsBean.ProgremBean> progremBeans;

    public SoftWareAdapter(List<ProgremsBean.ProgremBean> progremBeans) {
        this.progremBeans = progremBeans;
    }

    @NonNull
    @Override
    public SoftWareAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =   LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_software,parent,false);
        VH vh = new VH(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull SoftWareAdapter.VH holder, int position) {
        holder.tv_title.setText(progremBeans.get(position).getName());
        int num1 = (int)(Math.random() * 300) + position;
        holder.tv_msg_num.setText(String.valueOf(num1));
        int num2 =  (int)(Math.random() * 60) + position;
        holder.tv_star_num.setText(String.valueOf(num2));
    }

    @Override
    public int getItemCount() {
        return progremBeans.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.tv_star_num)
        TextView tv_star_num;
        @BindView(R.id.tv_msg_num)
        TextView tv_msg_num;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
