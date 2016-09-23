package com.netease.netease.controller.fragment.personfragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.netease.netease.R;
import com.netease.netease.controller.fragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/14.
 */
public class MessageFragment extends AbsBaseFragment {
    private ImageView msgIv;

    public static MessageFragment newInstance(int imgId) {

        Bundle args = new Bundle();
        args.putInt("key", imgId);
        MessageFragment fragment = new MessageFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initViews() {
        msgIv = findView(R.id.msg_img_iv);

    }

    @Override
    protected void initDatas() {
        Bundle b = getArguments();
        int imgI = b.getInt("key");
        Log.d("sss", "imgI:" + imgI);
        msgIv.setImageResource(imgI);
    }
}
