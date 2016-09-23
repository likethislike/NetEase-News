package com.netease.netease.controller.fragment.newsfragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.netease.netease.R;
import com.netease.netease.controller.adapter.newsadapter.RecreationAdapter;
import com.netease.netease.controller.fragment.AbsBaseFragment;
import com.netease.netease.model.bean.newsbean.NewsRecreationBean;
import com.netease.netease.model.net.OnVolleyResult;
import com.netease.netease.model.net.VolleyInstance;
import com.netease.netease.utils.ValueTools;

import java.util.List;

/**
 * Created by dllo on 16/9/22.
 * 新闻模块,娱乐界面fragment
 */
public class RecreationFragment extends AbsBaseFragment {
    private ListView recreationLv;
    private RecreationAdapter recreationAdapter;

    public static RecreationFragment newInstance() {

        Bundle args = new Bundle();

        RecreationFragment fragment = new RecreationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_recreation;
    }

    @Override
    protected void initViews() {
        recreationLv = findView(R.id.recreation_list_view);

    }

    @Override
    protected void initDatas() {
        //初始化适配器
        recreationAdapter = new RecreationAdapter(context);
        recreationLv.setAdapter(recreationAdapter);
        //解析网络数据
        VolleyInstance.getInstance().startRequest(ValueTools.NEWSRECREATIONURL, new OnVolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                NewsRecreationBean bean = gson.fromJson(resultStr, NewsRecreationBean.class);
                List<NewsRecreationBean.T1348648517839Bean> datas = bean.getT1348648517839();
                Log.d("RecreationFragment", "datas:" + datas);
                recreationAdapter.setDatas(datas);
            }

            @Override
            public void failure() {

            }
        });



    }
}
