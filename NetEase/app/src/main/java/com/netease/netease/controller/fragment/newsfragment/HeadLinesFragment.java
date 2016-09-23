package com.netease.netease.controller.fragment.newsfragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.netease.netease.R;
import com.netease.netease.controller.adapter.newsadapter.HeadLinesAdapter;
import com.netease.netease.controller.fragment.AbsBaseFragment;
import com.netease.netease.model.bean.newsbean.NewsHeadlineBean;
import com.netease.netease.model.net.OnVolleyResult;
import com.netease.netease.model.net.VolleyInstance;
import com.netease.netease.utils.ValueTools;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class HeadLinesFragment extends AbsBaseFragment {
    private ListView headlineLv;
    private HeadLinesAdapter headLinesAdapter;

    public static HeadLinesFragment newInstance() {

        Bundle args = new Bundle();
        HeadLinesFragment fragment = new HeadLinesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragmen_headlines;
    }

    @Override
    protected void initViews() {
        headlineLv = findView(R.id.headlines_list_view);

    }

    @Override
    protected void initDatas() {
        headLinesAdapter = new HeadLinesAdapter(context);
        headlineLv.setAdapter(headLinesAdapter);


        VolleyInstance.getInstance().startRequest(ValueTools.NEWSHEADLINEURL, new OnVolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                NewsHeadlineBean bean = gson.fromJson(resultStr, NewsHeadlineBean.class);
                List<NewsHeadlineBean.T1348647909107Bean> datas = bean.getT1348647909107();
                headLinesAdapter.setDatas(datas);
                Log.d("HeadLinesFragment", "datas:" + datas);
            }

            @Override
            public void failure() {

            }
        });

    }
}
