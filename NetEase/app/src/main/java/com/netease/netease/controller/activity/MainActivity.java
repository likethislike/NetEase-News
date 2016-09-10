package com.netease.netease.controller.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.RadioGroup;

import com.netease.netease.R;
import com.netease.netease.controller.fragment.NewsFragment;
import com.netease.netease.controller.fragment.OnlineFragment;
import com.netease.netease.controller.fragment.PersonFragment;
import com.netease.netease.controller.fragment.TalkFragment;

public class MainActivity extends AbsBaseActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup radioGroup;
    private NewsFragment newsFragment;
    private OnlineFragment onlineFragment;
    private TalkFragment talkFragment;
    private PersonFragment personFragment;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;

    }

    @Override
    protected void initView() {
        radioGroup = findView(R.id.main_netease_radio_group);
        newsFragment = new NewsFragment();
        onlineFragment = new OnlineFragment();
        talkFragment = new TalkFragment();
        personFragment = new PersonFragment();
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    @Override
    protected void initDatas() {
        //创建radioGroup点击事件
        radioGroup.setOnCheckedChangeListener(this);
        //设置进入界面显示的第一个Fragment
        radioGroup.check(R.id.main_netease_news);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //定义Fragment管理类和业务类
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (checkedId) {
            case R.id.main_netease_news:
                fragmentTransaction.replace(R.id.main_frame, newsFragment);
                break;
            case R.id.main_netease_online:
                fragmentTransaction.replace(R.id.main_frame, onlineFragment);
                break;
            case R.id.main_netease_talk:
                fragmentTransaction.replace(R.id.main_frame, talkFragment);
                break;
            case R.id.main_netease_person:
                fragmentTransaction.replace(R.id.main_frame, personFragment);
                break;
        }
        //提交业务
        fragmentTransaction.commit();
    }
}
