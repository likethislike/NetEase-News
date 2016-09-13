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
 * Created by dllo on 16/9/10.
 */
public class HeadLinesFragment extends Fragment{
    private ListView headlv;
    private TextView headtv;

    public static HeadLinesFragment newInstance(String str) {

        Bundle args = new Bundle();
        args.putString("text",str);
        HeadLinesFragment fragment = new HeadLinesFragment();
        //把这个数据传给fragment
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmen_headlines,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        headtv = (TextView) view.findViewById(R.id.headlines_tv);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        String string = bundle.getString("text");
        //使用
        headtv.setText(string);
    }
}
