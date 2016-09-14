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
public class AskFragment extends AbsBaseFragment {
    private ListView asklv;
    private TextView askTv;

    public static AskFragment newInstance(String str) {

        Bundle args = new Bundle();
        args.putString("text", str);
        AskFragment fragment = new AskFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_ask;
    }

    @Override
    protected void initViews() {
        asklv = findView(R.id.ask_list_view);
        askTv = findView(R.id.aks_tv);

    }

    @Override
    protected void initDatas() {
        Bundle bundle = getArguments();
        String string = bundle.getString("text");
        askTv.setText(string);

    }
}
