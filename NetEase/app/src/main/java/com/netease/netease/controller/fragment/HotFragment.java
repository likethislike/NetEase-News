package com.netease.netease.controller.fragment;

import android.widget.ListView;

import com.netease.netease.R;

/**
 * Created by dllo on 16/9/12.
 */
public class HotFragment extends AbsBaseFragment{
    private ListView hotlv;
    @Override
    protected int setLayout() {
        return R.layout.fragment_ask;
    }

    @Override
    protected void initViews() {
        hotlv = findView(R.id.hot_list_view);

    }

    @Override
    protected void initDatas() {

    }
}
