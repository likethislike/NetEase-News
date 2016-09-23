package com.netease.netease.controller.fragment.onlinefragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.netease.netease.R;
import com.netease.netease.controller.adapter.onlineadapter.OnlineAdapter;
import com.netease.netease.controller.fragment.AbsBaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class OnlineFragment extends AbsBaseFragment {
    private TabLayout onlineTl;
    private ViewPager onlineVp;
    private OnlineAdapter onlineAdapter;
    private List<Fragment> onlinedata;
    @Override
    protected int setLayout() {
        return R.layout.fragment_online;
    }

    @Override
    protected void initViews() {
        onlineTl = findView(R.id.online_tab_layout);
        onlineVp = findView(R.id.online_view_pager);
        onlinedata = new ArrayList<>();
        onlinedata.add(HotFragment.newInstance());
        onlinedata.add(ClassifyFragment.newInstance());
        //初始化适配器
        onlineAdapter = new OnlineAdapter(getChildFragmentManager(), onlinedata);
        onlineVp.setAdapter(onlineAdapter);
        //设置viewpager与tablayout联动
        onlineTl.setupWithViewPager(onlineVp);
        onlineTl.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

    @Override
    protected void initDatas() {
        String [] onlinetitle = {"热门","分类"};
        for (int i = 0; i < 2; i++) {
            onlineTl.getTabAt(i).setText(onlinetitle[i]);
        }
    }
}
