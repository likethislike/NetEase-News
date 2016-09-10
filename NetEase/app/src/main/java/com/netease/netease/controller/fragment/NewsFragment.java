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
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<Fragment> datas;
    private NewsAdapter newsAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initViews() {
        viewPager = findView(R.id.news_view_pager);
        tabLayout = findView(R.id.news_tab_layout);
        datas = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            datas.add(new HeadLinesFragment());
        }
        //创建适配器,并且绑定
        newsAdapter = new NewsAdapter(getChildFragmentManager(), datas);
        viewPager.setAdapter(newsAdapter);
        //设置ViewPager和TabLayout联动
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    protected void initDatas() {
        String[] title = {"头条", "精选", "娱乐", "体育", "网易号", "视频", "财经", "科技", "汽车", "时长", "图片", "直播", "热点", "军事", "历史", "家居"};
        for (int i = 0; i < 16; i++) {
            tabLayout.getTabAt(i).setText(title[i]);
        }

    }


}
