package com.redhood.hoolicalendar;



import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.alibaba.fastjson.JSON;
import com.android.volley.Request;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.redhood.hoolicalendar.fragment.PersonFragment;
import com.redhood.hoolicalendar.utils.ImmersiveStatusBarSettings;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        new ImmersiveStatusBarSettings().settingStatusBar(this);

        initCompent();
    }

    private void initCompent() {
        //初始化toolbar
//        Toolbar myToolbar = findViewById(R.id.my_toolbar);
//        setSupportActionBar(myToolbar);
        //设置底部导航
         bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setItemIconSize(60);

        BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomNav.getChildAt(0);
        menuView.scrollBy(0,8);
//        bottomNav.getMenu().findItem(R.id.navigation_add).setIcon(R.mipmap.add_icon);
        bottomNav.setItemIconTintList(null);
//        bottomNav.setText
        ImageView imageView = menuView.getChildAt(2).findViewById(com.google.android.material.R.id.icon);
//        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(80,80);
        imageView.getLayoutParams().width = 110;
        imageView.getLayoutParams().height = 110;
        imageView.scrollBy(0,0);

//设置模式
        bottomNav.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);

        navController = Navigation.findNavController(this, R.id.nav_host_container);
        NavigationUI.setupWithNavController(bottomNav, navController);

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
