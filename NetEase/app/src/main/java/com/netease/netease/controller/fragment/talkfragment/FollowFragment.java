package com.netease.netease.controller.fragment.talkfragment;

import android.widget.ImageView;

import com.netease.netease.R;
import com.netease.netease.controller.fragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/18.
 */
public class FollowFragment extends AbsBaseFragment{
    private ImageView followIv;
    @Override
    protected int setLayout() {
        return R.layout.fragment_follow;
    }

    @Override
    protected void initViews() {
     followIv = findView(R.id.talk_follow_iv);
    }

    @Override
    protected void initDatas() {

    }
}
