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
public class AskFragment extends Fragment{
    private ListView asklv;
    private TextView askTv;

    public static AskFragment newInstance(String str) {

        Bundle args = new Bundle();
        args.putString("text",str);
        AskFragment fragment = new AskFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ask,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        askTv = (TextView) view.findViewById(R.id.aks_tv);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        String string = bundle.getString("text");

        askTv.setText(string);

    }
}
