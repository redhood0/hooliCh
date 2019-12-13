package com.redhood.hoolicalendar.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.redhood.hoolicalendar.MainActivity;
import com.redhood.hoolicalendar.R;

import java.util.Arrays;

import androidx.fragment.app.Fragment;
import cn.bingoogolapple.bgabanner.BGABanner;

public class HomeSoftWareFragment extends Fragment {
    BGABanner banner_guide_content;
    String IMG_URL1 = "http://img2.imgtn.bdimg.com/it/u=3638674868,1392747070&fm=26&gp=0.jpg";
    String IMG_URL2 = "http://img2.imgtn.bdimg.com/it/u=3655873710,3949623444&fm=26&gp=0.jpg";
    String IMG_URL3 = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3841519465,1224124022&fm=26&gp=0.jpg";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_software, container, false);
        // Inflate the layout for this fragment
        banner_guide_content =  v.findViewById(R.id.banner_guide_content);
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
        return v;
    }
}
