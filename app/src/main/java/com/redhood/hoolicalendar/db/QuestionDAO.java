package com.redhood.hoolicalendar.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;


import com.redhood.hoolicalendar.bean.QuestionBean;
import com.redhood.hoolicalendar.bean.WrongQuestionBean;
import com.redhood.hoolicalendar.utils.RollOutUtil;

import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {
    private Context context;
    private SQLiteOpenHelper helper;

    public QuestionDAO(Context context) {
        this.context = context;
        helper = new DatabaseHelper(context);
    }

    public void addQuestion(ArrayList<QuestionBean> list) {
        SQLiteDatabase database = helper.getWritableDatabase();
        String sql = "insert into iot_question(question,type,select_A,select_B,select_C,select_D,answer) values(?,?,?,?,?,?,?)";
        SQLiteStatement stat = database.compileStatement(sql);
        //database
        for (QuestionBean qb : list) {
//            stat.bindString(1,qb.getQuestion());
//            stat.bindString(2,qb.getType());
//            stat.bindString(3,qb.getSelect_A());
//            stat.bindString(4,qb.getSelect_B());
//            stat.bindString(5,qb.getSelect_C());
//            stat.bindString(6,qb.getSelect_D());
//            stat.bindString(7,qb.getAnswer());
//            stat.executeInsert();
            ContentValues contentValues = new ContentValues();
            contentValues.put("question", qb.getQuestion());
            contentValues.put("select_A", qb.getSelect_A());
            contentValues.put("select_B", qb.getSelect_B());
            contentValues.put("select_C", qb.getSelect_C());
            contentValues.put("select_D", qb.getSelect_D());
            contentValues.put("type", qb.getType());
            contentValues.put("answer", qb.getAnswer());
            database.insert("iot_question", null, contentValues);
        }
        database.close();
    }

    public int qureyQnum() {
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.query("iot_question", new String[]{"_id"}, null, null, null, null, "_id DESC");
        cursor.moveToFirst();
        int id = 0;
        try {
            id = cursor.getInt(0);
        } catch (CursorIndexOutOfBoundsException e) {
            Log.e("SQLite", "first create table");
        }
        //database.close();
        return id;
    }

    /**
     * 回答题目用来更新的update
     *
     * @param questionBean
     */
    public void updateQuestion(QuestionBean questionBean) {
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        //在values中添加内容
        values.put("testtime", questionBean.getTesttime());
        values.put("wrongtime", questionBean.getWrongtime());
        values.put("righttime", questionBean.getRighttime());
        values.put("lastwrong", questionBean.getLastwrong());
        values.put("hardlevel", questionBean.getHardlevel());
        //修改条件
        String whereClause = "_id = ?";
        //修改添加参数
        String[] whereArgs = {String.valueOf(questionBean.getId())};
        //修改
        //int x =
        database.update("iot_question", values, whereClause, whereArgs);
        //database.close();
        return;
    }

    /**
     * 查询所有题目，根据做的次数由低到高排序
     *
     * @return
     */
    public List<QuestionBean> qureyAllQuestionByTestTimes() {
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor = database.query("iot_question", null
                , null, null, null, null, "testtime asc");

        List<QuestionBean> questionBeans = new ArrayList<>(2000);
        cursor.moveToFirst();
        if (cursor.getCount() == 0) {
            return questionBeans;
        }
        do {
            processCursor(cursor, questionBeans);
        } while (cursor.moveToNext());
        cursor.close();

        return questionBeans;
    }

    /**
     * 查询所有题目，根据id排序
     *
     * @return
     */
    public List<QuestionBean> qureyAllQuestionById() {
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor = database.query("iot_question", null
                , null, null, null, null, "_id asc");

        List<QuestionBean> questionBeans = new ArrayList<>(2000);
        cursor.moveToFirst();
        if (cursor.getCount() == 0) {
            return questionBeans;
        }
        do {
            processCursor(cursor, questionBeans);
        } while (cursor.moveToNext());
        cursor.close();

        return questionBeans;
    }

    /**
     * 查询题数有多少题一次都没有做过
     *
     * @return
     */
    public int qureyUnDoneQuentstionNum() {
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor = database.query("iot_question", null
                , "testtime = ?", new String[]{"0"}, null, null, null);
        cursor.moveToFirst();
        int n = cursor.getCount();
        return n;
    }

    /**old版本
     * 全部随机抽取，从题库中
     *
     * @param qnums
     * @return
     */
    public List<QuestionBean> old_qureyQuestion(int[] qnums) {
        SQLiteDatabase database = helper.getWritableDatabase();

        String[] qnum_str = new String[qnums.length];
        StringBuilder sb = new StringBuilder("_id in (");
        for (int i = 0; i < qnums.length; i++) {
            if (i != qnums.length - 1) {
                sb.append("?,");
            } else {
                sb.append("?");
            }
            qnum_str[i] = String.valueOf(qnums[i]);
        }
        sb.append(")");
        Cursor cursor = database.query("iot_question", null
                , sb.toString(), qnum_str, null, null, null);

        List<QuestionBean> questionBeans = new ArrayList<>(100);
        cursor.moveToFirst();
        if (cursor.getCount() == 0) {
            return questionBeans;
        }
        do {
            processCursor(cursor, questionBeans);
        } while (cursor.moveToNext());
        cursor.close();
//
//        for(QuestionBean qb : questionBeans){
//            LogUtil.loge(">>>qureyQuestion>>>",qb.toString());
//        }
        return questionBeans;
    }

    /**
     * 全部随机抽取，从题库中
     *
     * @param qnums
     * @return
     */
    public List<QuestionBean> qureyQuestion(int[] qnums) {
        SQLiteDatabase database = helper.getWritableDatabase();

        String[] qnum_str = {"judge","choice"};
        String sb = "type in (?,?)";


        Cursor cursor = database.query("iot_question", null
                , null, null, null, null, "RANDOM()", String.valueOf(qnums.length));

        List<QuestionBean> questionBeans = new ArrayList<>(100);
        cursor.moveToFirst();
        if (cursor.getCount() == 0) {
            return questionBeans;
        }
        do {
            processCursor(cursor, questionBeans);
        } while (cursor.moveToNext());
        cursor.close();
//
//        for(QuestionBean qb : questionBeans){
//            LogUtil.loge(">>>qureyQuestion>>>",qb.toString());
//        }
        return questionBeans;
    }

    /**
     * 错题中单选题
     */
    public List<QuestionBean> getChoiceWrongQuestion() {
        SQLiteDatabase database = helper.getReadableDatabase();
        List<QuestionBean> questionBeans = new ArrayList<>(64);

        Cursor cursor = database.query("iot_question", null
                , "hardlevel = ?,type = ?", new String[]{"usualWrong", "choice"}, null, null, null);
        if (cursor.getCount() == 0) {
            return questionBeans;
        }
        cursor.moveToFirst();
        do {
            processCursor(cursor, questionBeans);
        } while (cursor.moveToNext());
        return questionBeans;
    }

    /**
     * 错题中判断题题
     */
    public List<QuestionBean> getJudgeWrongQuestion() {
        SQLiteDatabase database = helper.getReadableDatabase();
        List<QuestionBean> questionBeans = new ArrayList<>(64);

        Cursor cursor = database.query("iot_question", null
                , "hardlevel = ?,type = ?", new String[]{"usualWrong", "judge"}, null, null, null);
        if (cursor.getCount() == 0) {
            return questionBeans;
        }
        cursor.moveToFirst();
        do {
            processCursor(cursor, questionBeans);
        } while (cursor.moveToNext());
        return questionBeans;
    }

    /**
     * 获取所有错题，并按照题型分开
     */
    public WrongQuestionBean getAllWrongQuestionByQType() {
        return new WrongQuestionBean(getChoiceWrongQuestion(), getJudgeWrongQuestion());
    }

    /**
     * 获得随机的错题
     */
    public List<QuestionBean> getRandomWrongQuestion(WrongQuestionBean wrongQuestionBean, int c_num, int q_num) {
        List<QuestionBean> results = new ArrayList<>(c_num + q_num);

        if(wrongQuestionBean.getJudges().size() < q_num | wrongQuestionBean.getChoices().size() < c_num){
            Log.e("DAO", "getRandomWrongQuestion: 数量异常，请检查方法getRandomWrongQuestion（）" );
            return results;
        }

        List<int[]> positions = RollOutUtil.rollOutWrong(c_num, q_num, wrongQuestionBean.getChoices().size(), wrongQuestionBean.getJudges().size());
        //获得的position要-1
        int[] cPositions = positions.get(0);
        int[] jPositions = positions.get(1);

        for (int pos : cPositions) {
            results.add(wrongQuestionBean.getChoices().get(pos - 1));
        }
        for (int pos : jPositions) {
            results.add(wrongQuestionBean.getJudges().get(pos - 1));
        }
        return results;
    }

    /**
     * 搜索错题,根据数据库id排序
     *
     * @return
     */
    public List<QuestionBean> qureyWrongQuestionByid() {
        SQLiteDatabase database = helper.getWritableDatabase();
        List<QuestionBean> questionBeans = new ArrayList<>(64);

        Cursor cursor = database.query("iot_question", null
                , "hardlevel = ?", new String[]{"usualWrong"}, null, null, null);
        if (cursor.getCount() == 0) {
            return questionBeans;
        }
        cursor.moveToFirst();
        do {
            processCursor(cursor, questionBeans);
        } while (cursor.moveToNext());
        return questionBeans;
    }

    /**
     * 搜索错题,根据数据库错误次数
     *
     * @return
     */

    public List<QuestionBean> qureyWrongQuestionByWrongTimes() {
        List<QuestionBean> questionBeans = new ArrayList<>(50);
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.query("iot_question", null
                , "hardlevel = ?", new String[]{"usualWrong"}, null, null, "wrongtime desc");
        if (cursor.getCount() == 0) {
            return null;
        }
        cursor.moveToFirst();
        do {
            processCursor(cursor, questionBeans);
        } while (cursor.moveToNext());
        return questionBeans;
    }

    /**
     * 删除错题
     */
    public void deleteWrongQuestion(QuestionBean questionBean) {
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        //在values中添加内容
        values.put("hardlevel", "normal");
        //修改条件
        String whereClause = "_id = ?";
        //修改添加参数
        String[] whereArgs = {String.valueOf(questionBean.getId())};
        database.update("iot_question", values, whereClause, whereArgs);
        //database.close();
        return;
    }

    /**
     * 搜索easy-question,根据数据库id排序
     *
     * @return
     */
    public List<QuestionBean> qureyEzQuestionByid() {
        SQLiteDatabase database = helper.getWritableDatabase();
        List<QuestionBean> questionBeans = new ArrayList<>(50);

        Cursor cursor = database.query("iot_question", null
                , "hardlevel = ?", new String[]{"ez"}, null, null, null);
        if (cursor.getCount() == 0) {
            return null;
        }
        cursor.moveToFirst();
        do {
            processCursor(cursor, questionBeans);
        } while (cursor.moveToNext());
        return questionBeans;
    }

    /**
     * 删easy-question题
     *
     * @param
     * @param
     */
    public void deleteEzQuestion(QuestionBean questionBean) {
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        //在values中添加内容
        values.put("hardlevel", "normal");
        //修改条件
        String whereClause = "_id = ?";
        //修改添加参数
        String[] whereArgs = {String.valueOf(questionBean.getId())};
        database.update("iot_question", values, whereClause, whereArgs);
        //database.close();
        return;
    }

    /**
     * 清空题库记录
     */
    public void clearQuestionBank() {
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("testtime", 0);
        values.put("wrongtime", 0);
        values.put("righttime", 0);
        values.put("hardlevel", "normal");
        values.put("lastwrong", "undone");
        database.update("iot_question", values, null, null);
        database.close();
        return;
    }


    private void processCursor(Cursor cursor, List<QuestionBean> questionBeans) {
        int id = cursor.getInt(cursor.getColumnIndex("_id"));
        String question = cursor.getString(cursor.getColumnIndex("question"));
        String type = cursor.getString(cursor.getColumnIndex("type"));
        String a_choice = cursor.getString(cursor.getColumnIndex("select_A"));
        String b_choice = cursor.getString(cursor.getColumnIndex("select_B"));
        String c_choice = cursor.getString(cursor.getColumnIndex("select_C"));
        String d_choice = cursor.getString(cursor.getColumnIndex("select_D"));
        String answer = cursor.getString(cursor.getColumnIndex("answer"));
        String q_class = cursor.getString(cursor.getColumnIndex("q_class"));
        int testtime = cursor.getInt(cursor.getColumnIndex("testtime"));
        int wrongtime = cursor.getInt(cursor.getColumnIndex("wrongtime"));
        int righttime = cursor.getInt(cursor.getColumnIndex("righttime"));
        String hardlevel = cursor.getString(cursor.getColumnIndex("hardlevel"));
        String lastwrong = cursor.getString(cursor.getColumnIndex("lastwrong"));

        QuestionBean qb = new QuestionBean();
        qb.setId(id);
        qb.setQuestion(question);
        qb.setType(type);
        qb.setSelect_A(a_choice);
        qb.setSelect_B(b_choice);
        qb.setSelect_C(c_choice);
        qb.setSelect_D(d_choice);
        qb.setAnswer(answer);
        qb.setqClass(q_class);
        qb.setTesttime(testtime);
        qb.setWrongtime(wrongtime);
        qb.setRighttime(righttime);
        qb.setHardlevel(hardlevel);
        qb.setLastwrong(lastwrong);
        qb.setAnswerStatus(2);
        questionBeans.add(qb);
    }


}
