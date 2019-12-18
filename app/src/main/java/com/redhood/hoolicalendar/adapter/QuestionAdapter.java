package com.redhood.hoolicalendar.adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


import com.redhood.hoolicalendar.bean.QuestionBean;
import com.redhood.hoolicalendar.fragment.DoQuestionFragment;

import java.util.List;

/**
 * @author cky
 * date 2019-10-11
 */
public class QuestionAdapter extends FragmentStatePagerAdapter {
    List<QuestionBean> questionBeanList;

    public QuestionAdapter(@NonNull FragmentManager fm, List<QuestionBean> questionBeanList) {
        super(fm);
        this.questionBeanList = questionBeanList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Log.d("getItem",position+"");
        return new DoQuestionFragment(position);
    }

    @Override
    public int getCount() {
        return questionBeanList.size();
    }
}
