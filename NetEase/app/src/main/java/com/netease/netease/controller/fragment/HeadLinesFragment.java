package com.netease.netease.controller.fragment;

import android.widget.ListView;

import com.netease.netease.R;

/**
 * Created by dllo on 16/9/10.
 */
public class HeadLinesFragment extends AbsBaseFragment{
    private ListView listView;
    @Override
    protected int setLayout() {
        return R.layout.fragmen_headlines;
    }

    @Override
    protected void initViews() {
        listView = findView(R.id.news_view_pager);

    }

    @Override
    protected void initDatas() {

    }
}
