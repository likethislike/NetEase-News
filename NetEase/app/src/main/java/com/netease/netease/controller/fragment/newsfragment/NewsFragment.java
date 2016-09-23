package com.netease.netease.controller.fragment.newsfragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.netease.netease.R;
import com.netease.netease.controller.adapter.newsadapter.NewsAdapter;
import com.netease.netease.controller.fragment.AbsBaseFragment;

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

    }

    @Override
    protected void initDatas() {
        newsdata = new ArrayList<>();
        newsdata.add(HeadLinesFragment.newInstance());
        newsdata.add(FeaturedFragment.newInstance());
        newsdata.add(RecreationFragment.newInstance());
        newsdata.add(SorptFragment.newInstance());

        //创建适配器,并且绑定
        newsAdapter = new NewsAdapter(getChildFragmentManager(), newsdata);
        newsVp.setAdapter(newsAdapter);
        //设置ViewPager和TabLayout联动
        newsTl.setupWithViewPager(newsVp);
        newsTl.setTabMode(TabLayout.MODE_SCROLLABLE);
        String[] title = {"头条", "精选", "娱乐", "体育", "网易号", "视频", "财经", "科技", "汽车", "时尚"};
        for (int i = 0; i < 4; i++) {
            newsTl.getTabAt(i).setText(title[i]);
        }
    }


}
