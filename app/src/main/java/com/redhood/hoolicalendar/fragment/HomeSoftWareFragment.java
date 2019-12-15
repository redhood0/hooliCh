package com.redhood.hoolicalendar.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.redhood.hoolicalendar.MainActivity;
import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.adapter.SoftWareAdapter;
import com.redhood.hoolicalendar.bean.NewsList;
import com.redhood.hoolicalendar.bean.ProgremsBean;
import com.redhood.hoolicalendar.callback.BeanCallback;
import com.redhood.hoolicalendar.utils.HttpRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import cn.bingoogolapple.bgabanner.BGABanner;

public class HomeSoftWareFragment extends Fragment implements BeanCallback {
    BGABanner banner_guide_content;
    RecyclerView rv_home_software;
    NestedScrollView ns_home_software;
    String IMG_URL1 = "http://img2.imgtn.bdimg.com/it/u=3638674868,1392747070&fm=26&gp=0.jpg";
    String IMG_URL2 = "http://img2.imgtn.bdimg.com/it/u=3655873710,3949623444&fm=26&gp=0.jpg";
    String IMG_URL3 = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3841519465,1224124022&fm=26&gp=0.jpg";
    private final static String SOFTWARE_LISTURL = "/openapi/project_list";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_software, container, false);
        //请求数据
        new HttpRequest(getContext(), this).getRequest(SOFTWARE_LISTURL,"", ProgremsBean.class);

        initContent(v);

        return v;
    }

    private void initContent(View v) {
        //初始化banner
        banner_guide_content =  v.findViewById(R.id.banner_guide_content);
        ns_home_software =  v.findViewById(R.id.ns_home_software);

        banner_guide_content.setAdapter(new BGABanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
                Glide.with(getActivity())
                        .load(model)
//                        .placeholder(R.drawable.holder)
//                        .error(R.drawable.holder)
                        .centerCrop()
//                        .dontAnimate()
                        .into(itemView);
            }
        });
        banner_guide_content.setData(Arrays.asList(IMG_URL1, IMG_URL2, IMG_URL3), Arrays.asList("WatchAD", "ApaChe", "LoCAL DB"));
        //初始化recyclerview
        rv_home_software = v.findViewById(R.id.rv_home_software);
        rv_home_software.setLayoutManager(new LinearLayoutManager(getContext()));
//        rv_home_software.setAdapter(new SoftWareAdapter());
    }

    @Override
    public void processBeanRequest(Object bean) {
        ProgremsBean pb =  (ProgremsBean)bean;
//        Log.e("processBeanRequest", "processBeanRequest: " + pb.getProjectlist() );
        List<ProgremsBean.ProgremBean> progremBeans = new ArrayList<>();
        int nums = pb.getProjectlist().size();
        for(int i = 0; i < nums; i+=2){
            progremBeans.add( pb.getProjectlist().get(i));
        }
        SoftWareAdapter sa =  new SoftWareAdapter(progremBeans);
        rv_home_software.setAdapter(sa);
    }

    @Override
    public void onResume() {
        super.onResume();
//        ns_home_software.smoothScrollTo(0,0);
//        rv_home_software.smoothScrollToPosition(0);

    }
}
