package com.netease.netease.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by dllo on 16/9/10.
 */
public abstract class AbsBaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //定制流程
        setContentView(setLayout());
        //初始化组件
        initView();
        //初始化数据
        initDatas();
    }
    //设置布局文件
    protected abstract int setLayout();
    //初始化组件
    protected abstract void initView();
    //初始化数据
    protected abstract void initDatas();
    //简化findViewById
    protected <T extends View> T findView(int resId){
        return (T) findViewById(resId);
    }
    //跳转不传值
    protected void goTo(Context from, Class<? extends AbsBaseActivity> to){
        startActivity(new Intent(from,to));
    }
    /**
     * 跳转传值
     * Bundle:轻量级的存储类,存储一些key_value形式的数据
     */
    protected void goTo(Context from, Class<? extends AbsBaseActivity> to,Bundle extras){
        Intent intent = new Intent(from, to);
        intent.putExtras(extras);
        startActivity(intent);
    }
    //Activity结束动画
    public void finis(){
        super.fileList();
    }


}
