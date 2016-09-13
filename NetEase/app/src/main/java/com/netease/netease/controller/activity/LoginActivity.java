package com.netease.netease.controller.activity;

import android.view.View;
import android.widget.ImageView;

import com.netease.netease.R;

/**
 * Created by dllo on 16/9/13.
 */
public class LoginActivity extends AbsBaseActivity implements View.OnClickListener {
    private ImageView backIv;
    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        backIv = findView(R.id.login_back);
        backIv.setOnClickListener(this);

    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_back:
                finish();
                break;
        }
    }
}
