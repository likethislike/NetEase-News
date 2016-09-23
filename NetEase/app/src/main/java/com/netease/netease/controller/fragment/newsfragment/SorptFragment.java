package com.netease.netease.controller.fragment.newsfragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.netease.netease.R;
import com.netease.netease.controller.adapter.newsadapter.SportAdapter;
import com.netease.netease.controller.fragment.AbsBaseFragment;
import com.netease.netease.model.bean.newsbean.NewsSportsBean;
import com.netease.netease.model.net.OnVolleyResult;
import com.netease.netease.model.net.VolleyInstance;
import com.netease.netease.utils.ValueTools;

import java.util.List;

/**
 * Created by dllo on 16/9/23.
 */
public class SorptFragment extends AbsBaseFragment{
    private ListView newsLv;
    private SportAdapter sportAdapter;

    public static SorptFragment newInstance() {

        Bundle args = new Bundle();

        SorptFragment fragment = new SorptFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_all_news;
    }

    @Override
    protected void initViews() {
        newsLv =findView(R.id.news_all_list_view);

    }

    @Override
    protected void initDatas() {
        sportAdapter = new SportAdapter(context);
        newsLv.setAdapter(sportAdapter);

        VolleyInstance.getInstance().startRequest(ValueTools.NEWSSORPTURL, new OnVolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                NewsSportsBean bean = gson.fromJson(resultStr,NewsSportsBean.class);
                List<NewsSportsBean.T1348649079062Bean> datas = bean.getT1348649079062();
                sportAdapter.setDatas(datas);
                Log.d("SorptFragment", "datas:" + datas);
            }

            @Override
            public void failure() {

            }
        });


    }
}
