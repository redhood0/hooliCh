package com.redhood.hoolicalendar.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.bean.TweetList;
import com.redhood.hoolicalendar.fragment.TweetNewFragment;
import com.redhood.hoolicalendar.utils.WindowUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author cky
 * date 2019-12-16
 * 动弹最新
 */
public class TweetNewAdapter extends RecyclerView.Adapter<TweetNewAdapter.ViewHolder> implements View.OnClickListener {
    private List<TweetList.TweetlistBean> lists;
    private TweetList.TweetlistBean tweetlistBean;
    private Context context;
    private CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public TweetNewAdapter(List<TweetList.TweetlistBean> lists, Context context) {
        this.lists = lists;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tweet_new, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.iv_tweet1.setTag(position);
        holder.iv_tweet2.setTag(position);
        holder.iv_tweet3.setTag(position);
        holder.tv_content.setTag(position);

        tweetlistBean = lists.get(position);
        if (context != null)
        Glide.with(context).load(tweetlistBean.getPortrait()).into(holder.civ_head);
        holder.tv_name.setText(tweetlistBean.getAuthor());
        holder.tv_time.setText(tweetlistBean.getPubDate());
        holder.tv_content.setText(Html.fromHtml(tweetlistBean.getBody()));

        holder.tv_content.setOnClickListener(this);


        if (tweetlistBean.getImgSmall() != null && !tweetlistBean.getImgSmall().equals("null")) {
            String[] imgUrls = transImgUrl(tweetlistBean.getImgSmall());
            ArrayList<String> array;
            if (imgUrls.length > 3) {
                array = new ArrayList<>();
                array.add(imgUrls[0]);
                array.add(imgUrls[1]);
                array.add(imgUrls[2]);
                holder.iv_tweet1.setOnClickListener(this);
                holder.iv_tweet2.setOnClickListener(this);
                holder.iv_tweet3.setOnClickListener(this);
            } else {
                array = new ArrayList<>(Arrays.asList(imgUrls));
                if (array.size()==1){
                    holder.iv_tweet1.setOnClickListener(this);
                }else if (array.size()==2){
                    holder.iv_tweet1.setOnClickListener(this);
                    holder.iv_tweet2.setOnClickListener(this);
                }
            }
            holder.cl_img.setVisibility(View.VISIBLE);
            for (int i = 0; i < array.size(); i++) {
                if (context != null){

                Glide.with(context).load(array.get(i)).placeholder(R.mipmap.ic_tweet_picture_normal).into(
                        holder.imgs[i]);
                }

            }
        }
    }

    /**
     * 转换图片地址
     * @param url
     * @return
     */
    public String[] transImgUrl(String url) {
        String str = url.substring(41);
        String[] result = str.split(",");
        return result;
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    @Override
    public void onClick(View view) {
        int position = (int) view.getTag();
        if (callBack != null) {
            switch (view.getId()) {
                case R.id.iv_tweet1:
                    callBack.showWindow(view, "iv_tweet1", position);
                    break;
                case R.id.iv_tweet2:
                    callBack.showWindow(view, "iv_tweet2", position);
                    break;
                case R.id.iv_tweet3:
                    callBack.showWindow(view, "iv_tweet3", position);
                    break;
                case R.id.tv_content:
                    callBack.showWindow(view, "tv_content", position);
                    break;
                default:
                    callBack.showWindow(view, "item", position);
            }
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView civ_head;
        TextView tv_name, tv_time, tv_content;
        ImageView iv_tweet1, iv_tweet2, iv_tweet3;
        ImageView[] imgs;
        ConstraintLayout cl_img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            civ_head = itemView.findViewById(R.id.civ_head);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_content = itemView.findViewById(R.id.tv_content);
            iv_tweet1 = itemView.findViewById(R.id.iv_tweet1);
            iv_tweet2 = itemView.findViewById(R.id.iv_tweet2);
            iv_tweet3 = itemView.findViewById(R.id.iv_tweet3);
            cl_img = itemView.findViewById(R.id.cl_img);
            imgs = new ImageView[]{iv_tweet1, iv_tweet2, iv_tweet3};

        }
    }

    public interface CallBack {
        void showWindow(View v, String name, int position);
    }
}
