package com.redhood.hoolicalendar.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SoftWareAdapter extends RecyclerView.Adapter<SoftWareAdapter.VH> {


    @NonNull
    @Override
    public SoftWareAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SoftWareAdapter.VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class VH extends RecyclerView.ViewHolder {

        public VH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
