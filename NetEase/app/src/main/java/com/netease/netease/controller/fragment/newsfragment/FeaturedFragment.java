package com.netease.netease.controller.fragment.newsfragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.netease.netease.R;
import com.netease.netease.controller.adapter.newsadapter.FeaturedAdapter;
import com.netease.netease.controller.fragment.AbsBaseFragment;
import com.netease.netease.model.bean.newsbean.NewsFeaturedBean;
import com.netease.netease.model.net.OnVolleyResult;
import com.netease.netease.model.net.VolleyInstance;
import com.netease.netease.utils.ValueTools;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/22.
 * 新闻模块,精选Fragment
 */
public class FeaturedFragment extends AbsBaseFragment {
    private ListView featuredLv;
    private FeaturedAdapter featuredAdapter;

    private View view;
    private List<NewsFeaturedBean.T1467284926140Bean> datas;

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
        datas = new ArrayList<>();
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
                datas = newsFeaturedBean.getT1467284926140();
                Log.d("qqq", "datas.size()11111:" + datas.size());
                featuredAdapter.setDatas(datas);
                /**
                 * 绑定头布局
                 */
                view = LayoutInflater.from(context).inflate(R.layout.news_feature_header, null);
                ImageView headerImg = (ImageView) view.findViewById(R.id.news_feature_title_iv);
                TextView titleTv = (TextView) view.findViewById(R.id.news_feature_title_tv);
                ImageView imageView = (ImageView) view.findViewById(R.id.news_feature_img_iv);
                imageView.setImageResource(R.mipmap.a6l);
                Picasso.with(context).load(datas.get(0).getImgsrc()).into(headerImg);
                titleTv.setText(datas.get(0).getTitle());
                featuredLv.addHeaderView(view);
            }

            @Override
            public void failure() {

            }
        });

    }
}
