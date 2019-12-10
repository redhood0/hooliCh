package com.redhood.hoolicalendar;



import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initCompent();

    }

    private void initCompent() {
        //初始化toolbar
//        Toolbar myToolbar = findViewById(R.id.my_toolbar);
//        setSupportActionBar(myToolbar);
        //设置底部导航
//sss

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setItemIconSize(70);

        BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomNav.getChildAt(0);
        menuView.scrollBy(0,-4);
//        bottomNav.getMenu().findItem(R.id.navigation_add).setIcon(R.mipmap.add_icon);
        bottomNav.setItemIconTintList(null);
//        bottomNav.setText
        ImageView imageView = menuView.getChildAt(2).findViewById(com.google.android.material.R.id.icon);
//        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(80,80);
        imageView.getLayoutParams().width = 120;
        imageView.getLayoutParams().height = 120;
        imageView.scrollBy(0,0);

//设置模式
        bottomNav.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_container);
        NavigationUI.setupWithNavController(bottomNav, navController);

    }
}
