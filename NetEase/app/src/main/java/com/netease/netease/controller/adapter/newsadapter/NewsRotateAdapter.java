package com.netease.netease.controller.adapter.newsadapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.netease.netease.R;
import com.netease.netease.model.bean.newsbean.NewsRecreationBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/28.
 */
public class NewsRotateAdapter extends PagerAdapter {
    private List<NewsRecreationBean.T1348648517839Bean> datas;
    private Context context;
    private LayoutInflater inflater;

    public NewsRotateAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<NewsRecreationBean.T1348648517839Bean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    /**
     * 为了让ViewPager到最后一页不会像翻书一样回到第一页
     * 设置页数为int最大值,这样向下滑动永远都是下一页
     */
    @Override
    public int getCount() {
        return datas == null ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * position是int最大值所以这里可能是几百甚至上千,因此取余避免数组越界
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int newPosition = position % datas.size();
        View containerView = inflater.inflate(R.layout.item_all_news_rotate, container, false);
        ImageView imageView = (ImageView) containerView.findViewById(R.id.news_all_rotate_img);
        TextView textView = (TextView) containerView.findViewById(R.id.news_all_rotate_tv);
        ImageView view = (ImageView) containerView.findViewById(R.id.rotate_img_iv);
        view.setImageResource(R.mipmap.a6l);

        if (newPosition % 2 == 0) {
            Picasso.with(context).load(datas.get(0).getAds().get(0).getImgsrc()).into(imageView);
            textView.setText(datas.get(0).getAds().get(0).getTitle());
        }else {
            Picasso.with(context).load(datas.get(0).getImgsrc()).into(imageView);
            textView.setText(datas.get(0).getTitle());
        }

        container.addView(containerView);
        return containerView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
