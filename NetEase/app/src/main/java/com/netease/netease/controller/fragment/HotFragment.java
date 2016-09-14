package com.netease.netease.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.netease.netease.R;

/**
 * Created by dllo on 16/9/12.
 */
public class HotFragment extends AbsBaseFragment{
    private ListView hotlv;
    private TextView hotTv;

    public static HotFragment newInstance(String str) {

        Bundle args = new Bundle();
        args.putString("text",str);
        HotFragment fragment = new HotFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initViews() {
        hotTv = findView(R.id.hot_tv);

    }

    @Override
    protected void initDatas() {
        Bundle bundle = getArguments();
        String string = bundle.getString("text");
        hotTv.setText(string);

    }
}
