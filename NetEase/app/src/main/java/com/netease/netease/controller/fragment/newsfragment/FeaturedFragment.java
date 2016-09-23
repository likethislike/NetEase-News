package com.netease.netease.controller.fragment.newsfragment;

import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.netease.netease.R;
import com.netease.netease.controller.adapter.newsadapter.FeaturedAdapter;
import com.netease.netease.controller.fragment.AbsBaseFragment;
import com.netease.netease.model.bean.newsbean.NewsFeaturedBean;
import com.netease.netease.model.net.OnVolleyResult;
import com.netease.netease.model.net.VolleyInstance;
import com.netease.netease.utils.ValueTools;

import java.util.List;

/**
 * Created by dllo on 16/9/22.
 * 新闻模块,精选Fragment
 */
public class FeaturedFragment extends AbsBaseFragment {
    private ListView featuredLv;
    private FeaturedAdapter featuredAdapter;

    public static FeaturedFragment newInstance() {

        Bundle args = new Bundle();

        FeaturedFragment fragment = new FeaturedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_featured;
    }

    @Override
    protected void initViews() {
        featuredLv = findView(R.id.featured_list_view);

    }

    @Override
    protected void initDatas() {
        featuredAdapter = new FeaturedAdapter(context);
        featuredLv.setAdapter(featuredAdapter);
        /**
         *  解析网络数据.使用Gson方法
         */
        VolleyInstance.getInstance().startRequest(ValueTools.NEWSFEATUREDURL, new OnVolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                NewsFeaturedBean newsFeaturedBean = gson.fromJson(resultStr, NewsFeaturedBean.class);
                List<NewsFeaturedBean.T1467284926140Bean> datas = newsFeaturedBean.getT1467284926140();
                featuredAdapter.setDatas(datas);
            }

            @Override
            public void failure() {

            }
        });


    }
}
