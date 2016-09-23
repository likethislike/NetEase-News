package com.netease.netease.controller.fragment.talkfragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.netease.netease.R;
import com.netease.netease.controller.adapter.topicadapter.TopicAdapter;
import com.netease.netease.controller.fragment.AbsBaseFragment;
import com.netease.netease.model.bean.talkbean.TopicBean;
import com.netease.netease.model.net.OnVolleyResult;
import com.netease.netease.model.net.VolleyInstance;
import com.netease.netease.utils.ValueTools;

import java.util.List;


/**
 * Created by dllo on 16/9/18.
 */
public class TopicFragment extends AbsBaseFragment{
    private ListView topiclv;
    private TopicAdapter topicAdapter;

    private ImageView topicHeaderIv;
    private TextView topicHeaderTv;


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
//        View view = LayoutInflater.from(context).inflate(R.layout.topic_list_header, null);
//        topicHeaderIv = (ImageView) view.findViewById(R.id.topic_header_iv);
//        topicHeaderTv = (TextView) view.findViewById(R.id.topic_header_tv);
//        for (int i = 0; i < 10; i++) {
//            topicHeaderTv.setText("dsad");
//        }
//
//        topiclv.addHeaderView(view);
        topicAdapter = new TopicAdapter(context);
        topiclv.setAdapter(topicAdapter);


        VolleyInstance.getInstance().startRequest(ValueTools.TALKTOPICURL, new OnVolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                TopicBean topicBean = gson.fromJson(resultStr,TopicBean.class);
                List<TopicBean.DataBean.SubjectListBean> datas = topicBean.getData().getSubjectList();
                Log.d("TopicFragment", "datas:" + datas);
                topicAdapter.setDatas(datas);

            }

            @Override
            public void failure() {

            }
        });


    }
}
