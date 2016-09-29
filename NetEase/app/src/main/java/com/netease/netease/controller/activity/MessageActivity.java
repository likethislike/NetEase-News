package com.netease.netease.controller.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.netease.netease.R;
import com.netease.netease.controller.adapter.personadapter.MessageAdapter;
import com.netease.netease.controller.fragment.personfragment.MessageFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 消息界面Activity
 */
public class MessageActivity extends AbsBaseActivity implements View.OnClickListener {
    private TabLayout msgTl;
    private ViewPager msgVp;
    private ImageView msgbackIv;
    private MessageAdapter messageAdapter;
    private List<Fragment> fragments;
    @Override
    protected int setLayout() {
        return R.layout.activity_message;
    }

    @Override
    protected void initView() {
        msgTl = findView(R.id.person_msg_tab_layout);
        msgVp = findView(R.id.person_msg_view_pager);
        msgbackIv = findView(R.id.msg_back_iv);

    }

    @Override
    protected void initDatas() {
        fragments = new ArrayList<>();
        fragments.add(MessageFragment.newInstance(R.mipmap.ach));
        fragments.add(MessageFragment.newInstance(R.mipmap.a97));
        /**
         * 创建适配器,并绑定
         */
        messageAdapter = new MessageAdapter(getSupportFragmentManager(),fragments);
        msgVp.setAdapter(messageAdapter);
        /**
         * 设置viewpager与tablayout联动
         */
        msgTl.setupWithViewPager(msgVp);

        msgTl.getTabAt(0).setText("评论我的");
        msgTl.getTabAt(1).setText("通知");
        msgbackIv.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.msg_back_iv:
                finish();
                break;
        }
    }
}
