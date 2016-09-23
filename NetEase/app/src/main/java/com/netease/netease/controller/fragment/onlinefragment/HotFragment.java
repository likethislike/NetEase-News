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
import com.netease.netease.controller.adapter.onlineadapter.HotAdapter;
import com.netease.netease.controller.fragment.AbsBaseFragment;
import com.netease.netease.model.bean.onlinebean.OnlineHotBean;
import com.netease.netease.utils.ValueTools;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by dllo on 16/9/12.
 * 直播模块,热门界面fragment
 */
public class HotFragment extends AbsBaseFragment {
    private ListView hotlv;
    private HotAdapter hotAdapter;
    private RequestQueue queue;

    public static HotFragment newInstance() {

        Bundle args = new Bundle();
        HotFragment fragment = new HotFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initViews() {
        hotlv = findView(R.id.hot_list_view);

    }

    @Override
    protected void initDatas() {
        hotAdapter = new HotAdapter(context);
        hotlv.setAdapter(hotAdapter);
        queue = Volley.newRequestQueue(context);
        JsonObjectRequest sr = new JsonObjectRequest(ValueTools.ONLINEHOTURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                OnlineHotBean bean = gson.fromJson(response.toString(), OnlineHotBean.class);
                List<OnlineHotBean.LiveReviewBean> datas = bean.getLive_review();
                hotAdapter.setDatas(datas);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(sr);

    }
}
