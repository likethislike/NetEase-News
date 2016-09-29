package com.netease.netease.controller.fragment.newsfragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.netease.netease.R;
import com.netease.netease.controller.adapter.newsadapter.NewsRotateAdapter;
import com.netease.netease.controller.adapter.newsadapter.RecreationAdapter;
import com.netease.netease.controller.fragment.AbsBaseFragment;
import com.netease.netease.model.bean.newsbean.NewsRecreationBean;
import com.netease.netease.model.net.OnVolleyResult;
import com.netease.netease.model.net.VolleyInstance;
import com.netease.netease.utils.ValueTools;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/22.
 * 新闻模块,娱乐界面fragment
 */
public class RecreationFragment extends AbsBaseFragment {
    private ListView recreationLv;
    private RecreationAdapter recreationAdapter;

    private NewsRotateAdapter rotateAdapter;
    private ViewPager viewPager;
    private LinearLayout pointLl;
    private Handler handler;
    private boolean isRotate;
    private Runnable rotateRunnable;
    private static final int TIME = 5000;


    public static RecreationFragment newInstance() {

        Bundle args = new Bundle();
        RecreationFragment fragment = new RecreationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {

        return R.layout.fragment_recreation;
    }

    @Override
    protected void initViews() {
        recreationLv = findView(R.id.recreation_list_view);
    }

    @Override
    protected void initDatas() {
        /**
         * 初始化适配器
         */
        recreationAdapter = new RecreationAdapter(context);
        recreationLv.setAdapter(recreationAdapter);
        /**
         * 绑定头布局
         */
        View view = LayoutInflater.from(context).inflate(R.layout.news_all_rotate, null);
        recreationLv.addHeaderView(view);
        viewPager = (ViewPager) view.findViewById(R.id.news_all_rotate);
        pointLl = (LinearLayout) view.findViewById(R.id.news_all_rotate_content);
        rotateAdapter = new NewsRotateAdapter(context);
        viewPager.setAdapter(rotateAdapter);

        /**
         * 解析网络数据
         */
        VolleyInstance.getInstance().startRequest(ValueTools.NEWSRECREATIONURL, new OnVolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                NewsRecreationBean bean = gson.fromJson(resultStr, NewsRecreationBean.class);
                List<NewsRecreationBean.T1348648517839Bean> datas = bean.getT1348648517839();
                recreationAdapter.setDatas(datas);
                rotateAdapter.setDatas(datas);

                /**
                 * 轮播图
                 */
                Rotate();
            }

            @Override
            public void failure() {

            }
        });
    }

    /**
     * 轮播图构造方法
     */
    private void Rotate() {
        /**
         *ViewPager的页数为int最大值,设置当前页多一些,可以上来就向前滑动
         * 为了保证第一页始终未数据的第0条 取余要为0,因此设置数据集合大小的倍数
         */
        viewPager.setCurrentItem(2 * 100);
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
         * 随着轮播改变小点
         */
        changePoints();
    }

    private void changePoints() {
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
                    for (int i = 0; i < 2; i++) {
                        ImageView pointIv = (ImageView) pointLl.getChildAt(i);
                        pointIv.setImageResource(R.mipmap.z0);
                    }
                    /**
                     * 设置当前位置小点为白色
                     */
                    ImageView iv = (ImageView) pointLl.getChildAt(position % 2);
                    iv.setImageResource(R.mipmap.z1);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 添加轮播切换小点
     * 有多少张图,加多少个点
     */
    private void addPoints() {
        for (int i = 0; i < 2; i++) {
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
                if (isRotate) {
                    handler.postDelayed(rotateRunnable, TIME);
                }
            }
        };
        handler.postDelayed(rotateRunnable, TIME);
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
