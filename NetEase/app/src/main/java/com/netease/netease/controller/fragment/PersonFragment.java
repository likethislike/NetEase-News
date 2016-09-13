package com.netease.netease.controller.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.netease.netease.R;
import com.netease.netease.controller.activity.LoginActivity;

/**
 * Created by dllo on 16/9/10.
 */
public class PersonFragment extends AbsBaseFragment implements View.OnClickListener {
    private Button loginBtn;
    private TextView concernTv, fanTv;

    @Override
    protected int setLayout() {
        return R.layout.fragment_person;
    }

    @Override
    protected void initViews() {
        loginBtn = findView(R.id.person_login_btn);
        concernTv = findView(R.id.person_my_concern_tv);
        fanTv = findView(R.id.person_my_fan_tv);
        loginBtn.setOnClickListener(this);
        concernTv.setOnClickListener(this);
        fanTv.setOnClickListener(this);

    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.person_login_btn:
                Intent login = new Intent(getActivity(), LoginActivity.class);
                startActivity(login);
                break;
            case R.id.person_my_concern_tv:
                Intent concern = new Intent(getActivity(), LoginActivity.class);
                startActivity(concern);
                break;
            case R.id.person_my_fan_tv:
                Intent fan = new Intent(getActivity(), LoginActivity.class);
                startActivity(fan);
                break;
        }
    }
}
