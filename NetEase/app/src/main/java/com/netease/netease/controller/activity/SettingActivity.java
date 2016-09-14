package com.netease.netease.controller.activity;

import android.view.View;
import android.widget.ImageView;

import com.netease.netease.R;

/**
 * Created by dllo on 16/9/14.
 */
public class SettingActivity extends AbsBaseActivity implements View.OnClickListener {
    private ImageView settingIv;
    @Override
    protected int setLayout() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView() {
        settingIv = findView(R.id.setting_back);
        settingIv.setOnClickListener(this);

    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setting_back:
                finish();
                break;
        }
    }
}
