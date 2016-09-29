package com.netease.netease.controller.fragment.onlinefragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.netease.netease.R;
import com.netease.netease.controller.adapter.onlineadapter.HotAdapter;
import com.netease.netease.controller.adapter.onlineadapter.HotRotateAdapter;
import com.netease.netease.controller.fragment.AbsBaseFragment;
import com.netease.netease.model.bean.onlinebean.OnlineHotBean;
import com.netease.netease.utils.ValueTools;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/12.
 * 直播模块,热门界面fragment
 */
public class HotFragment extends AbsBaseFragment {
    private ListView hotlv;
    private HotAdapter hotAdapter;
    private RequestQueue queue;
    private View view;


    private HotRotateAdapter rotateAdapter;
    private ViewPager viewPager;
    private Handler handler;
    private boolean isRotate;
    private Runnable rotateRunnable;
    private static final int TIME = 5000;
    private List<OnlineHotBean.TopBean> datas1;
    private LinearLayout pointLl;

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
        /**
         * 头布局
         */
        headerTitle();

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

    /**
     * 轮播图
     */
    private void headerTitle() {
        view = LayoutInflater.from(context).inflate(R.layout.news_all_rotate,null);
        hotlv.addHeaderView(view);
        viewPager = (ViewPager) view.findViewById(R.id.news_all_rotate);
        pointLl = (LinearLayout) view.findViewById(R.id.news_all_rotate_content);
        rotateAdapter = new HotRotateAdapter(context);
        viewPager.setAdapter(rotateAdapter);

        queue = Volley.newRequestQueue(context);
        JsonObjectRequest sr1 = new JsonObjectRequest(ValueTools.ONLINEHOTURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                OnlineHotBean bean1 = gson.fromJson(response.toString(),OnlineHotBean.class);
                datas1 = new ArrayList<>();
                datas1 = bean1.getTop();
                rotateAdapter.setDatas(datas1);
                /**
                 * ViewPager的页数为int最大值,设置当前页多一些,可以上来就向前滑动
                 * 为了确保第一页失踪为数据的第0条,取余要为0,因此设置数据集合大小的倍数
                 */
                viewPager.setCurrentItem(datas1.size() * 100);
                /**
                 * 开始轮播
                 */
                handler = new Handler();
                startRotate();
                /**
                 * 添加轮播小点
                 */
                addPoints();
                /**
                 * 随着轮播小点改变
                 */
                changePoint();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(sr1);


    }

    private void changePoint() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (isRotate) {
                    /**
                     * 把所有小点设置为灰色
                     */
                    for (int i = 0; i < datas1.size(); i++) {
                        ImageView pointIv = (ImageView) pointLl.getChildAt(i);
                        pointIv.setImageResource(R.mipmap.z0);
                    }
                    /**
                     * 设置当前位置小点为白色
                     */
                    ImageView iv = (ImageView) pointLl.getChildAt(position % datas1.size());
                    iv.setImageResource(R.mipmap.z1);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addPoints() {
        for (int i = 0; i < datas1.size(); i++) {
            ImageView pointIv = new ImageView(context);
            pointIv.setPadding(5, 5, 5, 5);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(25, 25);
            pointIv.setLayoutParams(params);
            /**
             * 设置第0页,小点为白色
             */
            if (i == 0) {
                pointIv.setImageResource(R.mipmap.z1);
            } else {
                pointIv.setImageResource(R.mipmap.z0);
            }
            pointLl.addView(pointIv);
        }

    }

    /**
     * 开始轮播
     */
    private void startRotate() {
        rotateRunnable = new Runnable() {
            @Override
            public void run() {
                int nowIndex = viewPager.getCurrentItem();
                viewPager.setCurrentItem(++nowIndex);
                if (isRotate){
                    handler.postDelayed(rotateRunnable,TIME);
                }
            }
        };
        handler.postDelayed(rotateRunnable,TIME);
    }

    @Override
    public void onResume() {
        super.onResume();
        isRotate = true;
    }

    @Override
    public void onPause() {
        super.onPause();
        isRotate = false;
    }
}
