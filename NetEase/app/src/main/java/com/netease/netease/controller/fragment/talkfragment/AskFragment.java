package com.netease.netease.controller.fragment.talkfragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.google.gson.Gson;
import com.netease.netease.R;
import com.netease.netease.controller.adapter.topicadapter.AskAdapter;
import com.netease.netease.controller.fragment.AbsBaseFragment;
import com.netease.netease.model.bean.talkbean.AskBean;
import com.netease.netease.model.net.OnVolleyResult;
import com.netease.netease.model.net.VolleyInstance;
import com.netease.netease.utils.ValueTools;

import java.util.List;

/**
 * Created by dllo on 16/9/12.
 */
public class AskFragment extends AbsBaseFragment {
    private RecyclerView askRl;
    private AskAdapter askAdapter;

    @Override
    protected int setLayout() {

        return R.layout.fragment_ask;
    }

    @Override
    protected void initViews() {
        askRl = findView(R.id.ask_recycle_view);

    }

    @Override
    protected void initDatas() {

        askAdapter = new AskAdapter(context);
        askRl.setAdapter(askAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        askRl.setLayoutManager(layoutManager);
        VolleyInstance.getInstance().startRequest(ValueTools.TALKASKURL, new OnVolleyResult() {
         @Override
         public void success(String resultStr) {
             Gson gson = new Gson();
             AskBean bean = gson.fromJson(resultStr, AskBean.class);
             List<AskBean.DataBean.ExpertListBean> datas = bean.getData().getExpertList();
             Log.d("qqq", "datas:" + datas);
             askAdapter.setDatas(datas);
         }

         @Override
         public void failure() {
             Log.d("aaa", "===");
         }
     });

    }
}
