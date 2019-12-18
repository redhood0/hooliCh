package com.redhood.hoolicalendar;


import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;


import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.redhood.hoolicalendar.activitys.QBActivity;
import com.redhood.hoolicalendar.fragment.PersonFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    NavController navController;
    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initCompent();
    }

    private void initCompent() {
        //设置底部导航
        bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setItemIconSize(60);
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomNav.getChildAt(0);
        menuView.scrollBy(0, 8);
//        bottomNav.getMenu().findItem(R.id.navigation_add).setIcon(R.mipmap.add_icon);
        bottomNav.setItemIconTintList(null);
//        bottomNav.setText
        ImageView addIcon = menuView.getChildAt(2).findViewById(com.google.android.material.R.id.icon);
//        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(80,80);
        addIcon.getLayoutParams().width = 110;
        addIcon.getLayoutParams().height = 110;
        addIcon.scrollBy(0, 0);
        addIcon.setClickable(true);
        addIcon.setOnClickListener(v -> {
            showPopUpWindow();
        });

//设置模式
        bottomNav.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);

        navController = Navigation.findNavController(this, R.id.nav_host_container);
        NavigationUI.setupWithNavController(bottomNav, navController);
    }

    private void showPopUpWindow() {
        popupWindow = new PopupWindow(this);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        View popup_add_icon = LayoutInflater.from(this).inflate(R.layout.popup_add_icon,null);
        popupWindow.setContentView(popup_add_icon);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
//        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        Log.e("ss", "showPopUpWindow: a");
        //引入依附的布局
//        View parentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_home, null);
        popupWindow.showAtLocation((View)bottomNav.getParent(), Gravity.TOP,0,0);
        ConstraintLayout llayout_popup = popup_add_icon.findViewById(R.id.llayout_popup);
        //获取图片
        ImageView iv_icon = popup_add_icon.findViewById(R.id.iv_icon);
        ImageView iv_icon2 = popup_add_icon.findViewById(R.id.iv_icon2);
        ImageView iv_icon3 = popup_add_icon.findViewById(R.id.iv_icon3);
        //设置动画
        iconDoAnimima(iv_icon);
        iconDoAnimima2(iv_icon2);
        iconDoAnimima3(iv_icon3);
        llayout_popup.setOnClickListener(v -> {
            Log.e("ss", "showPopUpWindow: " );
            popupWindow.dismiss();
        });

        iv_icon.setOnClickListener(v -> {
            Log.e("ss", "sb: " );
            Intent intent = new Intent(this, QBActivity.class);
            startActivity(intent);
            popupWindow.dismiss();
        });
    }

    private void iconDoAnimima(View view){
        ObjectAnimator oa = ObjectAnimator.ofFloat(view,"translationY",0,-300 );
        oa.setDuration(500);
        oa.start();
    }

    private void iconDoAnimima2(View view){
        ObjectAnimator oa = ObjectAnimator.ofFloat(view,"translationY",0,-150 );
        ObjectAnimator ob = ObjectAnimator.ofFloat(view,"translationX",0,-300 );

        oa.setDuration(500);
        ob.setDuration(500);
        oa.start();
        ob.start();
    }

    private void iconDoAnimima3(View view){
        ObjectAnimator oa = ObjectAnimator.ofFloat(view,"translationY",0,-150 );
        ObjectAnimator ob = ObjectAnimator.ofFloat(view,"translationX",0,300 );

        oa.setDuration(500);
        ob.setDuration(500);
        oa.start();
        ob.start();
    }

    /**
     * 清空 PersonFragment.myInformation缓存
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        PersonFragment.myInformation = null;
    }


}
