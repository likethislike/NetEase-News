package com.netease.netease.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.netease.netease.R;
import com.netease.netease.controller.adapter.HeadLinesAdapter;
import com.netease.netease.controller.adapter.NewsAdapter;
import com.netease.netease.model.bean.NewsBean;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class HeadLinesFragment extends AbsBaseFragment {
    private ListView headlv;
    private TextView headTv;
    private ImageView imgIv;
    //定义请求列队
    private RequestQueue queue;


    public static HeadLinesFragment newInstance(String str) {

        Bundle args = new Bundle();
        args.putString("text", str);
        HeadLinesFragment fragment = new HeadLinesFragment();
        //把这个数据传给fragment
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragmen_headlines;
    }

    @Override
    protected void initViews() {
        headlv = findView(R.id.headlines_list_view);
        headTv = findView(R.id.headlines_type_tv);
        imgIv = findView(R.id.headlines_img_iv);

    }

    @Override
    protected void initDatas() {
        Bundle bundle = getArguments();
        String string = bundle.getString("text");
        final HeadLinesAdapter headLinesAdapter = new HeadLinesAdapter(getContext());

        headlv.setAdapter(headLinesAdapter);
        //初始化请求队列
        queue = Volley.newRequestQueue(getContext());

        final StringRequest request = new StringRequest(string, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                NewsBean newsBean = gson.fromJson(response, NewsBean.class);
                //解析数据集合
                List<NewsBean.T1467284926140Bean> datas = newsBean.getT1467284926140();
                //设置数据给适配器
                headLinesAdapter.setDatas(datas);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);

    }
}
