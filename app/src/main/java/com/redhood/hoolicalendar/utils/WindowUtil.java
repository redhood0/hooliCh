package com.redhood.hoolicalendar.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.redhood.hoolicalendar.R;

import java.net.URL;

/**
 * @author cky
 * date 2019-12-16
 */
public class WindowUtil {
    public static PopupWindow popupWindow;

    private static void showWindow() {
        popupWindow = new PopupWindow();
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
    }

    public static void showHeadImgWindow(Context context, String url, View anchor) {
        showWindow();
        View view = LayoutInflater.from(context).inflate(R.layout.layout_show_pic, null, false);
        ImageView imageView = view.findViewById(R.id.iv_head);
        imageView.setVisibility(View.VISIBLE);
        Glide.with(context).load(url).into(imageView);
        popupWindow.setContentView(view);
        popupWindow.showAsDropDown(anchor);
        view.setOnClickListener(v -> {
            popupWindow.dismiss();
        });
    }
}
