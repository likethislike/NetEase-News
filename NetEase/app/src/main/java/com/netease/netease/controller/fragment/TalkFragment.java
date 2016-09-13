package com.netease.netease.controller.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.netease.netease.R;
import com.netease.netease.controller.adapter.TalkAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class TalkFragment extends AbsBaseFragment {
    private TalkAdapter talkAdapter;
    private TabLayout talkTl;
    private ViewPager talkVp;
    private List<Fragment> talkdatas;
    @Override
    protected int setLayout() {
        return R.layout.fragment_talk;
    }

    @Override
    protected void initViews() {
        talkTl = findView(R.id.talk_tab_layout);
        talkVp = findView(R.id.talk_view_pager);
        talkdatas = new ArrayList<>();
        talkdatas.add(AskFragment.newInstance("问吧"));
        talkdatas.add(AskFragment.newInstance("话题"));
        talkdatas.add(AskFragment.newInstance("关注"));
        //创建适配器,并且绑定
        talkAdapter = new TalkAdapter(getChildFragmentManager(), talkdatas);
        talkVp.setAdapter(talkAdapter);
        //设置ViewPager和TabLayout联动
        talkTl.setupWithViewPager(talkVp);
        talkTl.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

    @Override
    protected void initDatas() {
       String [] talktitle = {"问吧", "话题", "关注"};
        for (int i = 0; i < 3; i++) {
            talkTl.getTabAt(i).setText(talktitle[i]);
        }
    }
}
