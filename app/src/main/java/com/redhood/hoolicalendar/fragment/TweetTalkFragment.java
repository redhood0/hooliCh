package com.redhood.hoolicalendar.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.adapter.TweetTalkAdapter;
import com.redhood.hoolicalendar.bean.TweetTalkBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author cky
 * date 2019-12-15
 * 话题动弹
 */
public class TweetTalkFragment extends Fragment {
    List<TweetTalkBean> list;
    RecyclerView rv_talk;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tweet_talk,container,false);
        init(view);
        return view;
    }

    private void init(View view){
        initData();
        rv_talk = view.findViewById(R.id.rv_talk);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rv_talk.setLayoutManager(manager);
        TweetTalkAdapter adapter = new TweetTalkAdapter(list,getContext());
        rv_talk.setAdapter(adapter);
    }


    private void initData(){
        list = new ArrayList<>();
        {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("https://b-ssl.duitang.com/uploads/item/201608/21/20160821194924_UCvFZ.jpeg", "#如何看待NoToChrome#没什么优良的替代品");
            hashMap.put("http://pic3.zhimg.com/50/v2-0bf82b048a8f186160f0fab27e6483d0_hd.jpg", "#如何看待NoToChrome#没什么优良的替代品");
            hashMap.put("http://img3.imgtn.bdimg.com/it/u=1107263072,1224997471&fm=26&gp=0.jpg", "#如何看待NoToChrome#没什么优良的替代品");
            list.add(new TweetTalkBean("#如何看待NoToChrome#", hashMap, "共有8人参与"));
        }

        {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("https://b-ssl.duitang.com/uploads/item/201608/21/20160821194924_UCvFZ.jpeg", "#如何看待NoToChrome#没什么优良的替代品");
            hashMap.put("http://pic3.zhimg.com/50/v2-0bf82b048a8f186160f0fab27e6483d0_hd.jpg", "#如何看待NoToChrome#没什么优良的替代品");
            hashMap.put("http://img3.imgtn.bdimg.com/it/u=1107263072,1224997471&fm=26&gp=0.jpg", "#如何看待NoToChrome#没什么优良的替代品");
            list.add(new TweetTalkBean("#如何看待NoToChrome#", hashMap, "共有8人参与"));
        }

    }
}
