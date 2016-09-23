package com.netease.netease.controller.activity;

import android.view.View;
import android.widget.ImageView;

import com.netease.netease.R;

/**
 * Created by dllo on 16/9/16.
 * 意见与反馈界面
 */
public class FeedbackActivity extends AbsBaseActivity implements View.OnClickListener {
    private ImageView feedbackIv;
    @Override
    protected int setLayout() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void initView() {
        feedbackIv = findView(R.id.feed_back_iv);
        feedbackIv.setOnClickListener(this);

    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.feed_back_iv:
                 finish();
                 break;

         }

    }
}
