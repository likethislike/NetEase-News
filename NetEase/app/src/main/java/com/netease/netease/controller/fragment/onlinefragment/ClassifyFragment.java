package com.netease.netease.controller.fragment.onlinefragment;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.netease.netease.R;
import com.netease.netease.controller.adapter.onlineadapter.ClassifyAdapter;
import com.netease.netease.controller.fragment.AbsBaseFragment;
import com.netease.netease.model.bean.onlinebean.OnlineClassifyBean;
import com.netease.netease.model.bean.onlinebean.OnlineHotBean;
import com.netease.netease.utils.ValueTools;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by dllo on 16/9/23.
 * 直播模块,分类界面fragment
 */
public class ClassifyFragment extends AbsBaseFragment{
    private ListView classifyLv;
    private ClassifyAdapter classifyAdapter;

    private RequestQueue queue;

    public static ClassifyFragment newInstance() {

        Bundle args = new Bundle();

        ClassifyFragment fragment = new ClassifyFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {

        return R.layout.fragment_classify;
    }

    @Override
    protected void initViews() {
        classifyLv = findView(R.id.classify_list_view);


    }

    @Override
    protected void initDatas() {
        classifyAdapter = new ClassifyAdapter(context);
        classifyLv.setAdapter(classifyAdapter);
        queue = Volley.newRequestQueue(context);

        JsonObjectRequest sr = new JsonObjectRequest(ValueTools.ONLINECLASSIFY, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                OnlineClassifyBean bean = gson.fromJson(response.toString(), OnlineClassifyBean.class);
                List<OnlineClassifyBean.LiveReviewBean> datas = bean.getLive_review();
                classifyAdapter.setDatas(datas);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(sr);


    }
}
