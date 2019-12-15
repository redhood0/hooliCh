package com.redhood.hoolicalendar.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.redhood.hoolicalendar.R;

/**
 * @author cky
 * date 2019-12-15
 * 最新动弹
 */
public class TweetNewFragment extends Fragment {
    RecyclerView rv_tweet_new;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tweet_news,container,false);
        init(view);
        return view;
    }

    private void init(View view){
        rv_tweet_new = view.findViewById(R.id.rv_tweet_new);
    }

}
