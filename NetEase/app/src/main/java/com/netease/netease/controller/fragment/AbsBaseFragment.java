package com.netease.netease.controller.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netease.netease.controller.activity.AbsBaseActivity;

/**
 * Created by dllo on 16/9/10.
 */
public abstract class AbsBaseFragment extends Fragment{
    protected Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //初始化组件
        initViews();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //使用数据
        initDatas();
    }

    protected abstract int setLayout();

    protected abstract void initViews();

    protected abstract void initDatas();

    //初始化组件findViewById
    protected <T extends View> T findView(int resId){

        return (T) getView().findViewById(resId);
    }
    //跳转
    protected void goTo(Class<? extends AbsBaseActivity>to){
        context.startActivity(new Intent(context, to));
    }
}
