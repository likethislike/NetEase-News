package com.netease.netease.controller.fragment;

import android.widget.ListView;

import com.netease.netease.R;

/**
 * Created by dllo on 16/9/12.
 */
public class AskFragment extends AbsBaseFragment{
    private ListView asklv;
    @Override
    protected int setLayout() {
        return R.layout.fragment_ask;
    }

    @Override
    protected void initViews() {
        asklv = findView(R.id.talk_view_pager);

    }

    @Override
    protected void initDatas() {

    }
}
