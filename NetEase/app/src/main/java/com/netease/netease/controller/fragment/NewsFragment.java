package com.netease.netease.controller.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.netease.netease.R;
import com.netease.netease.controller.adapter.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class NewsFragment extends AbsBaseFragment {
    private ViewPager newsVp;
    private TabLayout newsTl;
    private List<Fragment> newsdata;
    private NewsAdapter newsAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initViews() {
        newsVp = findView(R.id.news_view_pager);
        newsTl = findView(R.id.news_tab_layout);
        newsdata = new ArrayList<>();
        //使用单列fragment方法
        newsdata.add(HeadLinesFragment.newInstance("头条"));
        newsdata.add(HeadLinesFragment.newInstance("精选"));
        newsdata.add(HeadLinesFragment.newInstance("娱乐"));
        newsdata.add(HeadLinesFragment.newInstance("体育"));
        newsdata.add(HeadLinesFragment.newInstance("易网号"));
        newsdata.add(HeadLinesFragment.newInstance("视频"));
        newsdata.add(HeadLinesFragment.newInstance("财经"));
        newsdata.add(HeadLinesFragment.newInstance("科技"));
        newsdata.add(HeadLinesFragment.newInstance("汽车"));
        newsdata.add(HeadLinesFragment.newInstance("时尚"));
        //创建适配器,并且绑定
        newsAdapter = new NewsAdapter(getChildFragmentManager(), newsdata);
        newsVp.setAdapter(newsAdapter);
        //设置ViewPager和TabLayout联动
        newsTl.setupWithViewPager(newsVp);
        newsTl.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    protected void initDatas() {
        String[] title = {"头条", "精选", "娱乐", "体育", "网易号", "视频", "财经", "科技", "汽车", "时尚"};
        for (int i = 0; i < 10; i++) {
            newsTl.getTabAt(i).setText(title[i]);
        }

    }


}
