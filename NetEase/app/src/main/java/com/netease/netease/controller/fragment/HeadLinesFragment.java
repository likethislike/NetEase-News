package com.netease.netease.controller.fragment;

import android.widget.ListView;

import com.netease.netease.R;

/**
 * Created by dllo on 16/9/10.
 */
public class HeadLinesFragment extends AbsBaseFragment{
    private ListView headlv;
    @Override
    protected int setLayout() {
        return R.layout.fragmen_headlines;
    }

    @Override
    protected void initViews() {
        headlv = findView(R.id.headlines_list_view);

    }

    @Override
    protected void initDatas() {

    }
}
