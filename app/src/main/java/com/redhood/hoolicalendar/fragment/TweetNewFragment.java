package com.redhood.hoolicalendar.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.adapter.TweetNewAdapter;
import com.redhood.hoolicalendar.bean.TweetList;
import com.redhood.hoolicalendar.callback.BeanCallback;
import com.redhood.hoolicalendar.utils.HttpRequest;
import com.redhood.hoolicalendar.utils.WindowUtil;

import java.util.List;

/**
 * @author cky
 * date 2019-12-15
 * 最新动弹
 */
public class TweetNewFragment extends Fragment implements BeanCallback {
    public static RecyclerView rv_tweet_new;
    List<TweetList.TweetlistBean> lists;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tweet_new, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        rv_tweet_new = view.findViewById(R.id.rv_tweet_new);
        new HttpRequest(getContext(), this).getRequest("/openapi/tweet_list", "", TweetList.class);
    }



    @Override
    public void processBeanRequest(Object bean) {
        lists = ((TweetList) bean).getTweetlist();
        Log.e("bean", bean.toString());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rv_tweet_new.setLayoutManager(manager);
        TweetNewAdapter adapter = new TweetNewAdapter(lists, getContext());
        adapter.setCallBack((v, name, position) -> {
            switch (name) {
                case "iv_tweet1":
                    WindowUtil.showHeadImgWindow(getContext(), adapter.transImgUrl(((TweetList) bean).getTweetlist().get(position).getImgBig())[0], rv_tweet_new);
                    break;
                case "iv_tweet2":
                    WindowUtil.showHeadImgWindow(getContext(), adapter.transImgUrl(((TweetList) bean).getTweetlist().get(position).getImgBig())[1], rv_tweet_new);
                    break;
                case "iv_tweet3":
                    WindowUtil.showHeadImgWindow(getContext(), adapter.transImgUrl(((TweetList) bean).getTweetlist().get(position).getImgBig())[2], rv_tweet_new);
                    break;
                case "tv_content":

                    break;
                    default:
                        break;
            }
        });
        rv_tweet_new.setAdapter(adapter);
        rv_tweet_new.setItemViewCacheSize(20);

    }
}
