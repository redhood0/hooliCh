package com.redhood.hoolicalendar.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.TransCoding;
import com.redhood.hoolicalendar.adapter.FindSoftwareAdapter;
import com.redhood.hoolicalendar.bean.FindBannerData;
import com.redhood.hoolicalendar.bean.FindSoftwareBean;
import com.redhood.hoolicalendar.ui.FindSoftwareDecoration;
import com.redhood.hoolicalendar.ui.FindViewHolder;
import com.zhpan.bannerview.BannerViewPager;
import com.zhpan.bannerview.constants.IndicatorGravity;
import com.zhpan.bannerview.holder.HolderCreator;
import com.zhpan.bannerview.holder.ViewHolder;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FindFragment extends Fragment {
    private BannerViewPager<FindBannerData, FindViewHolder> mBannerViewPager;
    RecyclerView rv_software;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);


        initConpent(view);
        return view;
    }

    private void initConpent(View view) {
        mBannerViewPager = view.findViewById(R.id.find_banner);
        rv_software = view.findViewById(R.id.rv_software);

        List<FindBannerData> data = new ArrayList<>();
        data.add(new FindBannerData(R.mipmap.banner1));
        data.add(new FindBannerData(R.mipmap.banner2));
        data.add(new FindBannerData(R.mipmap.banner3));

        List<FindSoftwareBean> softwareData = new ArrayList<>();
        softwareData.add(new FindSoftwareBean(R.mipmap.sotf1bg,"Halo","Halo Series in the game industry has a high visibility."));
        softwareData.add(new FindSoftwareBean(R.mipmap.sotf2bg,"VR-PGHB","Let the players float aimlessly between the earth and the moon under the music they like, and feel the mysterious universe"));
        softwareData.add(new FindSoftwareBean(R.mipmap.sotf3bg,"CHIPBOOM","The researchers integrated the luminescent properties of InP and the optical routing capability of silicon into a single hybrid chip."));
        softwareData.add(new FindSoftwareBean(R.mipmap.soft4,"SmartHome","Smart home is the embodiment of IOT under the influence of Internet."));
        softwareData.add(new FindSoftwareBean(R.mipmap.soft5,"",""));
        softwareData.add(new FindSoftwareBean(R.mipmap.soft6,"SmartTraffic","Intelligent transportation is a transportation oriented service system that makes full use of the Internet of things"));


        mBannerViewPager.setIndicatorVisibility(View.VISIBLE)
                .setInterval(3000)
                .setCanLoop(false)
                .setAutoPlay(true)
//                .setRoundCorner(DpUtils.dp2px(7))
                .setIndicatorColor(Color.parseColor("#935656"), Color.parseColor("#FF4C39"))
                .setIndicatorGravity(IndicatorGravity.CENTER)
                .setIndicatorColor(getResources().getColor(R.color.gray,null),getResources().getColor(R.color.themeGreen,null))
                .setIndicatorMargin(20,0,0,0)
                .setScrollDuration(1000).setHolderCreator(new HolderCreator<FindViewHolder>() {
            @Override
            public FindViewHolder createViewHolder() {
                return new FindViewHolder(FindFragment.this);
            }
        }).create(data);

        GridLayoutManager gm = new GridLayoutManager(getActivity(),2,RecyclerView.VERTICAL,false);
        rv_software.setLayoutManager(gm);
        rv_software.addItemDecoration(new FindSoftwareDecoration(10));
        rv_software.setAdapter(new FindSoftwareAdapter(softwareData,this));

    }


}
