package com.netease.netease.controller.adapter.onlineadapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.netease.netease.R;
import com.netease.netease.controller.fragment.onlinefragment.HotFragment;
import com.netease.netease.model.bean.onlinebean.OnlineHotBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/9/29.
 * 热门轮播图适配器
 */
public class HotRotateAdapter extends PagerAdapter {
    private Context context;
    private List<OnlineHotBean.TopBean> datas1;
    private LayoutInflater layout;

    public HotRotateAdapter(Context context) {
        this.context = context;
        layout = LayoutInflater.from(context);
    }


    public void setDatas(List<OnlineHotBean.TopBean> datas1) {
        this.datas1 = datas1;
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return datas1 == null ? 0 : Integer.MAX_VALUE;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int newPosition = position % datas1.size();

        View convertView = layout.inflate(R.layout.item_all_news_rotate, container, false);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.news_all_rotate_img);
        TextView textView = (TextView) convertView.findViewById(R.id.news_all_rotate_tv);
        ImageView view = (ImageView) convertView.findViewById(R.id.rotate_img_iv);
        view.setImageResource(R.mipmap.a5u);

        if (newPosition >= 0) {
            Picasso.with(context).load(datas1.get(newPosition).getImage()).into(imageView);
            textView.setText(datas1.get(newPosition).getRoomName());
        }

        container.addView(convertView);
        return convertView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
