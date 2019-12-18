package com.redhood.hoolicalendar.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.bean.QuestionBean;

import java.util.List;

/**
 * @author cky
 * date 2019-10-11
 */
public class AnswerSheetAdapter extends RecyclerView.Adapter<AnswerSheetAdapter.ViewHolder> {
    private JumpViewpager jumpViewpager;
    List<QuestionBean> questionBeanList;

    public AnswerSheetAdapter(List<QuestionBean> questionBeanList) {
        this.questionBeanList = questionBeanList;
    }

    public void setJumpViewpager(JumpViewpager jumpViewpager) {
        this.jumpViewpager = jumpViewpager;
    }

    public interface JumpViewpager{
        void jump(int position);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_answer_sheet,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_question_num.setText(position+1+"");
        holder.tv_question_num.setTextColor(Color.parseColor("#000000"));
        QuestionBean questionBean = questionBeanList.get(position);

        holder.iv_right_or_wrong.setImageResource(R.mipmap.circle_normal);

        if (questionBean.getAnswerStatus() == 0){
            holder.iv_right_or_wrong.setImageResource(R.mipmap.circle_wrong);
        }else if (questionBean.getAnswerStatus() == 1){
            holder.iv_right_or_wrong.setImageResource(R.mipmap.circle_write);
        }

        holder.itemView.setOnClickListener(v -> {
            if (jumpViewpager != null){
                jumpViewpager.jump(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return questionBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
         ImageView iv_right_or_wrong;
         TextView tv_question_num;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_right_or_wrong = itemView.findViewById(R.id.iv_right_or_wrong);
            tv_question_num = itemView.findViewById(R.id.tv_question_num);
        }
    }
}
