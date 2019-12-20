package com.redhood.hoolicalendar.activitys;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.fragment.QBHomeFragment;
import com.redhood.hoolicalendar.ui.BottomBar;
import com.redhood.hoolicalendar.utils.AssertUtil;
import com.redhood.hoolicalendar.utils.ImmersiveStatusBarSettings;


public class QBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qb_home);
        initView();
    }

    private void initView(){
//todo:delete--测试regex
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    ArrayList<QuestionBean> list =  RegularUtil2.processQuestion(MainActivity.this);
//                    QuestionDAO questionDAO = new QuestionDAO(MainActivity.this);
//                    questionDAO.addQuestion(list);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                AssertUtil.copyFile(QBActivity.this);
            }
        }).start();

        new ImmersiveStatusBarSettings().settingStatusBar(this);
        BottomBar bottomBar = findViewById(R.id.bottom_bar);
        bottomBar.setContainer(R.id.fl_container)
                .setTitleBeforeAndAfterColor("#999999", "#1A55CB")
                .addItem(QBHomeFragment.class,
                        "首页",
                        R.mipmap.home_before,
                        R.mipmap.home_after)
//                .addItem(QuestionFragment.class,
//                        "题库",
//                        R.mipmap.question_before,
//                        R.mipmap.question_after)
//                .addItem(SettingFragment.class,
//                        "设置",
//                        R.mipmap.setting_before,
//                        R.mipmap.setting_after)
                .build();

//        //google ads
//        MobileAds.initialize(this, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {
//
//            }
//        });


//        Log.e("new QuestionDAO(th", "initView: "+ new QuestionDAO(this).qureyAllQuestionByTestTimes().size());
//        if(new QuestionDAO(this).qureyQnum() < 2000){
//            try {
//                new QuestionDAO(this).addQuestion(RegularUtil.processQuestion(this));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        Log.e(">>>", "initView: >>>>>"+new QuestionDAO(this).qureyQnum());
    }
}
