package com.netease.netease.controller.fragment.personfragment;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.netease.netease.R;
import com.netease.netease.controller.activity.FeedbackActivity;
import com.netease.netease.controller.activity.LoginActivity;
import com.netease.netease.controller.activity.MessageActivity;
import com.netease.netease.controller.activity.SettingActivity;
import com.netease.netease.controller.fragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/10.
 */
public class PersonFragment extends AbsBaseFragment implements View.OnClickListener {
    private Button loginBtn;
    private TextView concernTv, fanTv, mymsgTv, registerTv;
    private TextView collectionTv, threadTv, goldTv;
    private TextView trendTv, goldtaskTv, walletTv, feedbackTv;
    private LinearLayout setlayout, wechatlayout, twitterlayout, qqlayout;


    @Override
    protected int setLayout() {
        return R.layout.fragment_person;
    }

    @Override
    protected void initViews() {
        loginBtn = findView(R.id.person_login_btn);
        concernTv = findView(R.id.person_my_concern_tv);
        fanTv = findView(R.id.person_my_fan_tv);
        setlayout = findView(R.id.person_set);
        mymsgTv = findView(R.id.person_my_msg_tv);
        registerTv = findView(R.id.person_register_tv);
        wechatlayout = findView(R.id.person_WeChat_layout);
        twitterlayout = findView(R.id.person_Twitter_layout);
        qqlayout = findView(R.id.person_QQ_layout);
        collectionTv = findView(R.id.person_collection_tv);
        threadTv = findView(R.id.person_Thread_tv);
        goldTv = findView(R.id.person_Gold_tv);
        trendTv = findView(R.id.person_Trends_tv);
        goldtaskTv = findView(R.id.person_Gold_Task_tv);
        walletTv = findView(R.id.person_Wallet_tv);
        feedbackTv = findView(R.id.person_feedback_tv);

        loginBtn.setOnClickListener(this);
        concernTv.setOnClickListener(this);
        fanTv.setOnClickListener(this);
        setlayout.setOnClickListener(this);
        mymsgTv.setOnClickListener(this);
        registerTv.setOnClickListener(this);
        wechatlayout.setOnClickListener(this);
        twitterlayout.setOnClickListener(this);
        qqlayout.setOnClickListener(this);
        collectionTv.setOnClickListener(this);
        threadTv.setOnClickListener(this);
        goldTv.setOnClickListener(this);
        trendTv.setOnClickListener(this);
        goldtaskTv.setOnClickListener(this);
        walletTv.setOnClickListener(this);
        feedbackTv.setOnClickListener(this);

    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
            case R.id.person_set:
                Intent set = new Intent(getActivity(), SettingActivity.class);
                startActivity(set);
                break;
            case R.id.person_my_msg_tv:
                Intent msg = new Intent(getActivity(), MessageActivity.class);
                startActivity(msg);
                break;
            case R.id.person_register_tv:
                Intent register = new Intent(Intent.ACTION_VIEW, Uri.parse("http://reg.163.com/reg/reg_mob2.jsp"));
                startActivity(register);
                break;
            case R.id.person_WeChat_layout:
                Toast.makeText(context, "抱歉,您尚未安装微信客户端,无法进行微信登录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.person_Twitter_layout:
                Toast.makeText(context, "抱歉,您尚未安装微博客户端,无法进行微博登录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.person_QQ_layout:
                Toast.makeText(context, "抱歉,您尚未安装QQ客户端,无法进行QQ登录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.person_collection_tv:
                Intent collection = new Intent(getActivity(), LoginActivity.class);
                startActivity(collection);
                break;
            case R.id.person_Thread_tv:
                Intent thread = new Intent(getActivity(), LoginActivity.class);
                startActivity(thread);
                break;
            case R.id.person_Gold_tv:
                Intent gold = new Intent(getActivity(), LoginActivity.class);
                startActivity(gold);
                break;
            case R.id.person_Trends_tv:
                Intent Trend = new Intent(getActivity(), LoginActivity.class);
                startActivity(Trend);
                break;
            case R.id.person_Gold_Task_tv:
                Intent goldtask = new Intent(getActivity(), LoginActivity.class);
                startActivity(goldtask);
                break;
            case R.id.person_Wallet_tv:
                Intent wallet = new Intent(getActivity(), LoginActivity.class);
                startActivity(wallet);
                break;
            case R.id.person_feedback_tv:
                Intent feedback = new Intent(getActivity(), FeedbackActivity.class);
                startActivity(feedback);
                break;
        }
    }
}
