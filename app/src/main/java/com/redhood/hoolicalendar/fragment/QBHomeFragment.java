package com.redhood.hoolicalendar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.activitys.DoQuestionActivity;
import com.redhood.hoolicalendar.activitys.QuestionRoundActivity;
import com.redhood.hoolicalendar.db.TestDAO;

import java.util.HashMap;

/**
 * @author cky
 * date 2019-10-10
 */
public class QBHomeFragment extends Fragment implements View.OnClickListener {
    TextView tv_title,tv_question_edit,tv_question_finish_num;
    Button btn_do_question;
    TextView tv_select;
    String judge_choice_num = "100";
    String multiple_choice_num = "100";
    String question_distribution = "随机抽取";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.qb_fragment_home, container, false);
        initView(view);
        return view;
    }

    private void initView(View view){
        tv_title = view.findViewById(R.id.tv_title);
        tv_question_edit = view.findViewById(R.id.tv_question_edit);//题库中修改
        btn_do_question = view.findViewById(R.id.btn_do_question);//题库中开始做题
        tv_select = view.findViewById(R.id.tv_select);//题库中开始做题
        tv_question_finish_num = view.findViewById(R.id.tv_question_finish_num);

        tv_question_edit.setOnClickListener(this);
        btn_do_question.setOnClickListener(this);
        tv_title.setText("首页");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_question_edit:
                Intent intent = new Intent(getContext(), QuestionRoundActivity.class);
                startActivityForResult(intent,1);
                break;
            case R.id.btn_do_question:
                DoQuestionFragment.recoders = new HashMap<>(128);
                Intent intent1 = new Intent(new Intent(getContext(), DoQuestionActivity.class));
                intent1.putExtra("question_distribution",question_distribution);
                intent1.putExtra("multiple_choice_num",multiple_choice_num);
                intent1.putExtra("judge_choice_num","0");
                startActivity(intent1);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 10){
            question_distribution = data.getStringExtra("question_distribution");
            multiple_choice_num = data.getStringExtra("multiple_choice_num");
            judge_choice_num = data.getStringExtra("judge_choice_num");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
//        tv_select.setText("单选："+multiple_choice_num+"题，判断："+judge_choice_num+"题  【"+question_distribution+"】");
        tv_select.setText("总题数："+multiple_choice_num+"题  【"+question_distribution+"】");
        tv_question_finish_num.setText(String.valueOf(new TestDAO(getContext()).getTodayRecord()));

    }

}
