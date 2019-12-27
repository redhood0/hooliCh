package com.redhood.hoolicalendar.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.redhood.hoolicalendar.R;
import com.redhood.hoolicalendar.adapter.TweetTalkAdapter;
import com.redhood.hoolicalendar.bean.TweetTalkBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author cky
 * date 2019-12-15
 * 话题动弹
 */
public class TweetTalkFragment extends Fragment {
    private List<TweetTalkBean> list;
    RecyclerView rv_talk;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tweet_talk,container,false);
        init(view);
        return view;
    }

    private void init(View view){
        initData();
        rv_talk = view.findViewById(R.id.rv_talk);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rv_talk.setLayoutManager(manager);
        TweetTalkAdapter adapter = new TweetTalkAdapter(list,getContext());
        rv_talk.setAdapter(adapter);
    }


    private void initData(){
        list = new ArrayList<>();
        {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("https://b-ssl.duitang.com/uploads/item/201608/21/20160821194924_UCvFZ.jpeg", "#如何看待NoToChrome#没什么优良的替代品");
            hashMap.put("http://pic3.zhimg.com/50/v2-0bf82b048a8f186160f0fab27e6483d0_hd.jpg", "#如何看待NoToChrome#挺好用的");
            hashMap.put("http://img3.imgtn.bdimg.com/it/u=1107263072,1224997471&fm=26&gp=0.jpg", "#如何看待NoToChrome#存了我一千多个密码");
            list.add(new TweetTalkBean("#如何看待NoToChrome#", hashMap, "共有8人参与"));
        }

        {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=4099228832,61723854&fm=26&gp=0.jpg",
                    "#李彦宏遭观众泼水#人的本能反应不应该是用手臂推开的吗，李总为啥低着头等着淋完？");
            hashMap.put("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1150708904,51866951&fm=26&gp=0.jpg",
                    "#李彦宏遭观众泼水#一个小人物都能拿着一瓶不明液体靠近老板？");
            hashMap.put("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=237281916,1583830106&fm=26&gp=0.jpg",
                    "#李彦宏遭观众泼水#今年算是最没下限的热点营销把");
            list.add(new TweetTalkBean("#李彦宏被泼水#", hashMap, "共有8人参与"));
        }
        {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=148817663,3386391366&fm=26&gp=0.jpg",
                    "#国庆节快乐#祖国只要需要我，闭包引用变量就不会消亡");
            hashMap.put("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1150708904,51866951&fm=26&gp=0.jpg",
                    "#国庆节快乐#祝大家头发浓密，睡眠充足，财务自由");
            hashMap.put("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=237281916,1583830106&fm=26&gp=0.jpg",
                    "#国庆节快乐#本来计划失去深圳玩去的，奈何各种安排变故不穷");
            list.add(new TweetTalkBean("#国庆节快乐#", hashMap, "共有34人参与"));
        }
        {
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("http://img4.imgtn.bdimg.com/it/u=2214249015,2755491113&fm=15&gp=0.jpg","#再坚持一会儿定律#四不四真的哦？");
            hashMap.put("http://imgsrc.baidu.com/forum/pic/item/788672f0f736afc3bf54aa92bd19ebc4b6451232.jpg","#再坚持一会儿定律#经验告诉我，当你在检查bug临近崩溃的时候，一...");
            hashMap.put("http://www.jshddq.net/UploadFiles/img_0_3641810861_2501321703_26.jpg","#再坚持一会儿定律#再坚持一会，你就有充分的理由放弃了");
            list.add(new TweetTalkBean("#再坚持一会儿定律#",hashMap,"共有5人参与"));
        }
        {
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("http://5b0988e595225.cdn.sohucs.com/images/20171216/031e490e7db54f88947665a5fce6e95c.jpeg","#余庆年居然是科幻片#额，本来就是，需要剧透吗");
            hashMap.put("http://b-ssl.duitang.com/uploads/item/201608/21/20160821194924_UCvFZ.jpeg","#余庆年居然是科幻片#经验告诉我，没看，第一眼看着像民国片。。。");
            hashMap.put("http://pic3.zhimg.com/50/v2-ed3df8233f628be769436ffed300a917_hd.jpg","#余庆年居然是科幻片#对啊，地球n年后");
            list.add(new TweetTalkBean("#余庆年居然是科幻片#",hashMap,"共有6人参与"));
        }
        {
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("http://pic2.zhimg.com/50/v2-1c3bd9fe6c6a28c5ca3a678549dfde28_hd.jpg","#第一批90后30岁倒计时#哈哈，90后，你们也到30了啊，我是80后！...");
            hashMap.put("http://img3.imgtn.bdimg.com/it/u=1107263072,1224997471&fm=26&gp=0.jpg","#第一批90后30岁倒计时#想想30岁的我，一点出息也没有，一无所有，...");
            hashMap.put("http://pic1.zhimg.com/50/v2-bf96fb79c5290318bfb4b3f70c8f88e4_hd.jpg","#第一批90后30岁倒计时#我80后，想当年我30岁的时候，90后才20岁，...");
            list.add(new TweetTalkBean("#第一批90后30岁倒计时#",hashMap,"共有22人参与"));
        }
        {
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("http://b-ssl.duitang.com/uploads/item/201509/21/20150921173512_PehaH.jpeg","#我太难了#京东E卡只要输入16位16进制密码就可以了，卡号不用输。它...");
            hashMap.put("http://b-ssl.duitang.com/uploads/item/201607/26/20160726185736_yPmrE.thumb.224_0.jpeg","#我太难了##我太难了# 溜了溜了，一个去年毕业工作一年多的，让把依赖的fas...");
            hashMap.put("http://pic3.zhimg.com/50/v2-0bf82b048a8f186160f0fab27e6483d0_hd.jpg","#我太难了#通了，我还是买个十二万以内的车吧，省油不易坏保养便宜就行了。那么问题来了...");
            list.add(new TweetTalkBean("#我太难了#",hashMap,"共有22人参与"));
        }
    }
}
