package com.redhood.hoolicalendar.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.bean.TweetTalkBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author cky
 * date 2019-12-20
 */
public class TweetTalkAdapter extends RecyclerView.Adapter<TweetTalkAdapter.ViewHolder>{
    private List<TweetTalkBean> list;
    private Context context;
    int[] backgrounds = {R.mipmap.bg_topic_1,R.mipmap.bg_topic_2,R.mipmap.bg_topic_3,R.mipmap.bg_topic_4,R.mipmap.bg_topic_5};

    public TweetTalkAdapter(List<TweetTalkBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tweet_talk,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TweetTalkBean tweetTalkBean = list.get(position);
        holder.tv_title.setText(tweetTalkBean.getTitle());
        holder.tv_title.setBackgroundResource(backgrounds[position]);
        holder.tv_4.setText(tweetTalkBean.getPerson());
        HashMap<String, String> hashMap = tweetTalkBean.getHashMap();
        int i= 0;
        for (Map.Entry<String, String> entry :hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Glide.with(context).load(key).into(holder.circleImageViews[i]);
            holder.textViews[i].setText(value);
            i++;

        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title,tv_1,tv_2,tv_3,tv_4;
        CircleImageView civ_1,civ_2,civ_3;
        TextView[] textViews;
        CircleImageView[] circleImageViews;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_1 = itemView.findViewById(R.id.tv_1);
            tv_2 = itemView.findViewById(R.id.tv_2);
            tv_3 = itemView.findViewById(R.id.tv_3);
            tv_4 = itemView.findViewById(R.id.tv_4);
            civ_1 = itemView.findViewById(R.id.civ_1);
            civ_2 = itemView.findViewById(R.id.civ_2);
            civ_3 = itemView.findViewById(R.id.civ_3);

            textViews = new TextView[]{tv_1,tv_2,tv_3};
            circleImageViews = new CircleImageView[]{civ_1,civ_2,civ_3};
        }
    }
}
