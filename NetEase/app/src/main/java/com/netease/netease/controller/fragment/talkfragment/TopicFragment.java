package com.netease.netease.controller.fragment.talkfragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.netease.netease.R;
import com.netease.netease.controller.adapter.topicadapter.TopicAdapter;
import com.netease.netease.controller.adapter.topicadapter.TopicHeaderAdapter;
import com.netease.netease.controller.fragment.AbsBaseFragment;
import com.netease.netease.model.bean.talkbean.TopicBean;
import com.netease.netease.model.bean.talkbean.TopicHeaderBean;
import com.netease.netease.model.net.OnVolleyResult;
import com.netease.netease.model.net.VolleyInstance;
import com.netease.netease.utils.ValueTools;

import java.util.List;


/**
 * Created by dllo on 16/9/18.
 * 话题模块,话题界面fragment
 */
public class TopicFragment extends AbsBaseFragment {
    private ListView topiclv;
    private TopicAdapter topicAdapter;
    private TopicHeaderAdapter headerAdapter;
    private RecyclerView recyclerView;

    @Override
    protected int setLayout() {
        return R.layout.fragment_topic;


    }

    @Override
    protected void initViews() {

        topiclv = findView(R.id.topic_list_view);


    }

    @Override
    protected void initDatas() {
        /**
         * 绑定头布局
         */
        View view = LayoutInflater.from(context).inflate(R.layout.talk_topic_header, null);
        topiclv.addHeaderView(view);
        recyclerView = (RecyclerView) view.findViewById(R.id.topic_header_rl);
        headerAdapter = new TopicHeaderAdapter(context);
        recyclerView.setAdapter(headerAdapter);

        GridLayoutManager manager = new GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);


        topicAdapter = new TopicAdapter(context);
        topiclv.setAdapter(topicAdapter);


        VolleyInstance.getInstance().startRequest(ValueTools.TALKTOPICURL, new OnVolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                TopicBean topicBean = gson.fromJson(resultStr, TopicBean.class);
                List<TopicBean.DataBean.SubjectListBean> datas = topicBean.getData().getSubjectList();
                Log.d("TopicFragment", "datas:" + datas);
                topicAdapter.setDatas(datas);
            }

            @Override
            public void failure() {

            }
        });

        VolleyInstance.getInstance().startRequest(ValueTools.TALKTOPICHEADERURL, new OnVolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                TopicHeaderBean topicHeaderBean = gson.fromJson(resultStr, TopicHeaderBean.class);
                List<TopicHeaderBean.话题Bean> datas = topicHeaderBean.get话题();
                headerAdapter.setDatas(datas);
            }

            @Override
            public void failure() {

            }
        });


    }
}
